package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.ProductVo;
import io.ukoko.bhwms.entity.Product;
import io.ukoko.bhwms.entity.RecordStock;
import io.ukoko.bhwms.mapper.ProductMapper;
import io.ukoko.bhwms.mapper.RecordStockMapper;
import io.ukoko.bhwms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RecordStockMapper recordStockMapper;

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public Page getProductPage(int pageNo, int pageSize, String productName, String productSize, Integer isDelete, Date startTime, Date endTime) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<Product> productList = productMapper.getProductList(null,productName, productSize, isDelete, startTime, endTime);
        PageInfo<Product> info = new PageInfo<>(productList);
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setPageCount(info.getPages());
        page.setCount(info.getTotal());
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setData(info.getList());
        return page;
    }

    @Override
    public List<Product> getProductList(String productId, String productName) {
        return productMapper.getProductList(productId,productName,null,null,null,null);
    }

    @Override
    public ProductVo getProduct(Integer productId, Integer repoId) {
        ProductVo productVo = new ProductVo();
        //产品信息
        Product product = productMapper.getProductByProductId(productId);
        //产品的库存信息
        List<RecordStock> recordStockList = recordStockMapper.getRecordStockList(productId, repoId);

        //获取产品库存总数
        if(recordStockList!=null){
            long stock = 0;
            for (RecordStock recordStock : recordStockList) {
                stock+=recordStock.getProductStock();
            }
            productVo.setStock(stock);
        }
        productVo.setProductId(product.getProductId());
        productVo.setProductName(product.getProductName());
        productVo.setCategoryId(product.getCategoryId());
        productVo.setCategory(product.getCategory());
        productVo.setProductSize(product.getProductSize());
        productVo.setProductPrice(product.getProductPrice());
        productVo.setCreateTime(product.getCreateTime());
        productVo.setUpdateTime(product.getUpdateTime());
        productVo.setIsDelete(product.getIsDelete());
        return productVo;
    }


    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productMapper.deleteProduct(productId);
    }

    @Override
    public void batchDeleteProduct(List<Integer> productIds) {
        productMapper.batchDeleteProduct(productIds);
    }
}
