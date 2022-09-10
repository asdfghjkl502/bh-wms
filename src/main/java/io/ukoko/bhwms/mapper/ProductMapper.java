package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库产品表(product)的接口类
 */
@Mapper
public interface ProductMapper {

    /**
     * 添加产品
     * @param product
     */
    void addProduct(Product product);

    /**
     * 多条件查询
     * @param product
     * @return
     */
    List<Product> getProductList(Product product);

    /**
     * 删除
     * @param productId
     */
    void deleteProduct(Integer productId);
}
