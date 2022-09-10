package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;

/**
 * 产品管理模块的业务逻辑层
 */
public interface ProductService {

    /**
     * 多条件查询
     * @return
     */
    Page getProductBy(Integer limit,Integer offset,String productName,Integer categoryId,Double productPrice,String productSize,Integer productId,Integer isDelete);

    /**
     * 删除
     * @param productId
     */
    void deleteProduct(Integer productId);
}
