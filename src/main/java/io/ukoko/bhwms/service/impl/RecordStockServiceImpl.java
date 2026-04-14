package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.RecordInOutDto;
import io.ukoko.bhwms.entity.*;
import io.ukoko.bhwms.enums.BhWmsStatus;
import io.ukoko.bhwms.exceptions.BhWmsException;
import io.ukoko.bhwms.mapper.*;
import io.ukoko.bhwms.service.RecordStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@Transactional
@Service
public class RecordStockServiceImpl implements RecordStockService {

    @Autowired
    private RecordStockMapper recordStockMapper;
    @Autowired
    private RecordInMapper recordInMapper;
    @Autowired
    private RecordOutMapper recordOutMapper;

    @Autowired
    private RepositoryMapper repositoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private CustomerMapper customerMapper;


    /**
     * 入库
     *
     * @param recordStock
     */
    @Override
    public void inRecordStock(RecordInOutDto recordStock) {
        Integer repoId = recordStock.getRepoId();
        Repository repositoryByRepoId = repositoryMapper.getRepositorybyRepoId(repoId);
        Integer productId = recordStock.getProductId();
        Product productByProductId = productMapper.getProductByProductId(productId);
        Integer supplierId = recordStock.getSupplierId();
        Supplier supplierBySuppierId = supplierMapper.getSupplierBySuppierId(supplierId);
        if (repositoryByRepoId == null) {
            throw new BhWmsException(500, "仓库不存在！");
        }
        if (productByProductId == null) {
            throw new BhWmsException(500, "产品不存在！");
        }
        if (supplierBySuppierId == null) {
            throw new BhWmsException(500, "供应商不存在！");
        }

        int productSize;
        String productSizeStr = productByProductId.getProductSize();
        if (productSizeStr != null && productSizeStr.contains("*")) {
            String[] parts = productSizeStr.split("\\*");
            if (parts.length < 2) {
                throw new BhWmsException(500, "产品尺寸格式错误！");
            }
            try {
                productSize = parseInt(parts[0].trim()) * parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                throw new BhWmsException(500, "产品尺寸格式错误！");
            }
        } else {
            try {
                productSize = parseInt(productSizeStr.trim());
            } catch (NumberFormatException e) {
                throw new BhWmsException(500, "产品尺寸格式错误！");
            }
        }

        int repoArea;
        String repoAreaStr = repositoryByRepoId.getRepoArea();
        if (repoAreaStr != null && repoAreaStr.contains("*")) {
            String[] parts = repoAreaStr.split("\\*");
            if (parts.length < 2) {
                throw new BhWmsException(500, "仓库面积格式错误！");
            }
            try {
                repoArea = parseInt(parts[0].trim()) * parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                throw new BhWmsException(500, "仓库面积格式错误！");
            }
        } else {
            try {
                repoArea = parseInt(repoAreaStr.trim());
            } catch (NumberFormatException e) {
                throw  new BhWmsException(500, "仓库面积格式错误！");
            }
        }

        System.out.println(productSize);
        System.out.println(repoArea);

        if (repositoryByRepoId.getRepoStatus()!=1 || repositoryByRepoId.getIsDelete()!=1 ){
            throw  new BhWmsException(500,"仓库异常！");
        } else if (productByProductId.getIsDelete()!=1) {
            throw  new BhWmsException(500,"该产品已失效！");
        } else if (supplierBySuppierId.getIsDelete()!=1) {
            throw  new BhWmsException(500,"该供应商已失效！");
        }

        // 计算仓库已占用面积
        List<RecordStock> allRecordStocks = recordStockMapper.getRecordStockList(null, repoId);
        int usedArea = 0;
        for (RecordStock rs : allRecordStocks) {
            if (rs.getProduct() != null && rs.getProduct().getProductSize() != null) {
                String sizeStr = rs.getProduct().getProductSize();
                int pSize;
                if (sizeStr.contains("*")) {
                    String[] parts = sizeStr.split("\\*");
                    pSize = parseInt(parts[0].trim()) * parseInt(parts[1].trim());
                } else {
                    pSize = parseInt(sizeStr.trim());
                }
                usedArea += pSize * rs.getProductStock();
            }
        }

        // 检查入库后总面积是否超过仓库面积
        int newUsedArea = usedArea + (productSize * recordStock.getProductStock());
        if (newUsedArea > repoArea) {
            throw  new BhWmsException(500,"仓库面积不足！");
        }
        RecordStock rs = new RecordStock();
        rs.setRepoId(recordStock.getRepoId());
        rs.setProductStock(recordStock.getProductStock());
        rs.setProductId(recordStock.getProductId());
        List<RecordStock> recordStocks = recordStockMapper.getRecordStockList(recordStock.getProductId(), recordStock.getRepoId());


        if(recordStocks!=null && recordStocks.size()>0){
            //存在直接入库
            recordStockMapper.inRecordStock(rs);
        }else{
            //不存在需要插入
            rs.setCreateTime(new Date());
            recordStockMapper.addRecordStock(rs);
        }
        //添加入库记录(向入库记录表中记录数据)
        RecordIn recordIn = new RecordIn();
        recordIn.setCreateTime(new Date());
        recordIn.setProductId(recordStock.getProductId());
        recordIn.setIsDelete(1);
        recordIn.setRecordInNumber(recordStock.getProductStock());
        recordIn.setRecordInTime(new Date());
        recordIn.setRepoId(recordStock.getRepoId());
        recordIn.setSupplierId(recordStock.getSupplierId());
        recordIn.setUserId(recordStock.getUserId());
        recordInMapper.addRecordIn(recordIn);
    }

    /**
     * 当天入库
     * @return
     */
    @Override
    public int getShipmentQuantityForToday() {
        Integer shipmentQuantityForToday = recordInMapper.getShipmentQuantityForToday();
        return Objects.nonNull(shipmentQuantityForToday)?shipmentQuantityForToday:0;
    }

    /**
     * 出库
     * @param recordStock
     */
    @Override
    public void outRecordStock(RecordInOutDto recordStock) {
        if(recordStock.getProductId()!=null && recordStock.getRepoId()!=null){

            Integer repoId = recordStock.getRepoId();
            Repository repositoryByRepoId = repositoryMapper.getRepositorybyRepoId(repoId);
            if (repositoryByRepoId == null) {
                throw new BhWmsException(500, "仓库不存在！");
            }
            Integer customerId = recordStock.getCustomerId();
            Customer customerByCustomerId = customerMapper.getCustomerByCustomerId(customerId);
            if (customerByCustomerId == null) {
                throw new BhWmsException(500, "客户不存在！");
            }
            if (repositoryByRepoId.getRepoStatus()!=1 || repositoryByRepoId.getIsDelete()!=1 ){
                throw  new BhWmsException(500,"仓库异常！");
            } else if (customerByCustomerId.getIsDelete()!=1) {
                throw  new BhWmsException(500,"该客户已失效！");
            }
            RecordStock rs = new RecordStock();
            rs.setRepoId(recordStock.getRepoId());
            rs.setProductStock(recordStock.getProductStock());
            rs.setProductId(recordStock.getProductId());
            List<RecordStock> recordStocks = recordStockMapper.getRecordStockList(recordStock.getProductId(), recordStock.getRepoId());
            if(recordStocks!=null && recordStocks.size()>0){
                //获取第一个
                RecordStock stock = recordStocks.get(0);
                //库存不够
                if(stock.getProductStock()<recordStock.getProductStock()){
                    throw new BhWmsException(BhWmsStatus.REPO_NOT_STOCK);
                }else{
                    //出库
                    recordStockMapper.outRecordStock(rs);
                    //添加出库记录
                    RecordOut recordOut = new RecordOut();
                    recordOut.setCreateTime(new Date());
                    recordOut.setProductId(recordStock.getProductId());
                    recordOut.setIsDelete(1);
                    recordOut.setRecordOutNumber(recordStock.getProductStock());
                    recordOut.setRecordOutTime(new Date());
                    recordOut.setRepoId(recordStock.getRepoId());
                    recordOut.setCustomerId(recordStock.getCustomerId());
                    recordOut.setUserId(recordStock.getUserId());
                    recordOutMapper.addRecordOut(recordOut);
                }
            }else {
                throw new BhWmsException(BhWmsStatus.REPO_NOT_PRODUCT);
            }
        }else{
            throw new BhWmsException(BhWmsStatus.REPO_NOT_PARAM);
        }
    }

    @Override
    public int getPurchaseQuantityForToday() {
        Integer purchaseQuantityForToday = recordOutMapper.getPurchaseQuantityForToday();
        return Objects.nonNull(purchaseQuantityForToday)?purchaseQuantityForToday:0;
    }

    /**
     * 通过仓库Id和产品Id查询仓库信息
     * @param repoId
     * @param productId
     * @return
     */
    @Override
    public RecordStock getRecordStockByRepoIdAndProductId(Integer repoId, Integer productId) {
        List<RecordStock> recordStockList = recordStockMapper.getRecordStockList(productId, repoId);
        if (recordStockList == null || recordStockList.isEmpty()) {
            return null;
        }
        return recordStockList.get(0);
    }

    @Override
    public int getRecordStockSum() {
        return recordStockMapper.getRecordStockSum();
    }

    @Override
    public Integer getProductCountWithLowStock() {
        Integer productCountWithLowStock = recordStockMapper.getProductCountWithLowStock();
        return Objects.nonNull(productCountWithLowStock)?productCountWithLowStock:0;
    }

    /**
     * 分页查询库存信息
     * @param pageNo
     * @param pageSize
     * @param repoId
     * @param productId
     * @return
     */
    @Override
    public Page getRecordStockPage(Integer pageNo, Integer pageSize, Integer repoId, Integer productId) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<RecordStock> recordStockList = recordStockMapper.getRecordStockList(productId, repoId);
        PageInfo<RecordStock> pageInfo = new PageInfo<>(recordStockList);
        page.setData(pageInfo.getList());
        page.setCount(pageInfo.getTotal());
        page.setPageCount(pageInfo.getPages());
        page.setPageNo(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setHasNext(pageInfo.isHasNextPage());
        return page;
    }
}
