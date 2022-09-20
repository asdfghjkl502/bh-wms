package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest extends BhWmsApplicationTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void addProduct() {

        for (int i = 0; i < 200; i++) {

            Product product = new Product();
            product.setProductName("测试商品名称"+i);
            product.setCategoryId(9);
            product.setProductSize("尺寸"+i);
            product.setProductPrice(i+100.12);
            product.setCreateTime(new Date());
            product.setIsDelete(i%2==0?1:0);
            productMapper.addProduct(product);
        }
        
    }

    @Test
    void getProductList() {
        List<Product> productList = productMapper.getProductList("0", null, null, null, null);
        productList.forEach(System.out::println);
    }
}