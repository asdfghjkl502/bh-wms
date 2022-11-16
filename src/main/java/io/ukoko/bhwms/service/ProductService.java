package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 产品管理模块的业务逻辑层
 */
public interface ProductService {

    /*
        添加产品
     */
    void addProduct(Product product);
    /*
        获取列表
     */
    Page getProductPage(int pageNo, int pageSize,String productName,String productSize,Integer isDelete,Date startTime,Date endTime);

    /**
     * 更新
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 通过ID删除
     * @param productId
     */
    void deleteProduct(Integer productId);

    /**
     * 批量删除
     * @param productIds
     */
    void batchDeleteProduct(List<Integer> productIds);
}
