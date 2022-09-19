package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库产品表(product)的接口类
 */
@Mapper
public interface ProductMapper {

    /**
     * 添加
     */
    void addProduct(Product product);

    /**
     * 获取列表
     */
    List<Product> getProductList(@Param("productName") String productName,@Param("productSize") String productSize, @Param("isDelete") Integer isDelete,@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}
