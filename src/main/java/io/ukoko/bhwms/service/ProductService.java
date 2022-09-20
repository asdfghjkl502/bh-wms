package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

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
    Page getProductPage(int offset, int limit,String productName,String productSize,Integer isDelete,Date startTime,Date endTime);
}
