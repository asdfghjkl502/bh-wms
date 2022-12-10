package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.dto.RecordInOutDto;
import io.ukoko.bhwms.entity.RecordIn;
import io.ukoko.bhwms.entity.RecordStock;
import io.ukoko.bhwms.enums.BhWmsStatus;
import io.ukoko.bhwms.exceptions.BhWmsException;
import io.ukoko.bhwms.mapper.RecordInMapper;
import io.ukoko.bhwms.mapper.RecordStockMapper;
import io.ukoko.bhwms.service.RecordStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class RecordStockServiceImpl implements RecordStockService {

    @Autowired
    private RecordStockMapper recordStockMapper;
    @Autowired
    private RecordInMapper recordInMapper;

    /**
     * 入库
     * @param recordStock
     */
    @Override
    public void inRecordStock(RecordInOutDto recordStock) {
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
     * 出库
     * @param recordStock
     */
    @Override
    public void outRecordStock(RecordInOutDto recordStock) {
        if(recordStock.getProductId()!=null && recordStock.getRepoId()!=null){
            List<RecordStock> recordStocks = recordStockMapper.getRecordStockList(recordStock.getProductId(), recordStock.getRepoId());
            if(recordStocks!=null && recordStocks.size()>0){
                //获取第一个
                RecordStock stock = recordStocks.get(0);
                //库存不够
                if(stock.getProductStock()<recordStock.getProductStock()){
                    throw new BhWmsException(BhWmsStatus.REPO_NOT_STOCK);
                }else{
                    RecordStock rs = new RecordStock();
                    rs.setRepoId(recordStock.getRepoId());
                    rs.setProductStock(recordStock.getProductStock());
                    rs.setProductId(recordStock.getProductId());
                    //出库
                    recordStockMapper.outRecordStock(rs);
                    //TODO... 添加出库记录
                }
            }else {
                throw new BhWmsException(BhWmsStatus.REPO_NOT_PRODUCT);
            }
        }else{
            throw new BhWmsException(BhWmsStatus.REPO_NOT_PARAM);
        }
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
        return recordStockList==null?null:recordStockList.get(0);
    }
}
