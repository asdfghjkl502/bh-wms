package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 产品
 */
class ProductMapperTest extends BhWmsApplicationTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void addProduct() {
        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            product.setProductName("产品"+i);
            product.setProductPrice(100.01+i);
            product.setProductSize("300*"+(i+100)+" mm");
            product.setCategoryId(i%2==0?i+1:2);
            product.setCreateTime(new Date());
            product.setIsDelete(1);
            productMapper.addProduct(product);
        }
    }

    @Test
    void getProductList() {
        Product product = new Product();
        //product.setProductId(2);
        //product.setCategoryId(2);
        product.setProductName("0");
        productMapper.getProductList(product).forEach(System.out::println);
    }
}