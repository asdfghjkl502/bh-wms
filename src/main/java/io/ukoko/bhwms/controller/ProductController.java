package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Product;
import io.ukoko.bhwms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "产品模块")
@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
        添加
     */
    @PostMapping(value = "/addProduct")
    public Object addProduct(Product product){
        productService.addProduct(product);
        return new Result();
    }

    /*
        获取产品分页
     */
    @GetMapping(value = "/getProductPage")
    public Object getProductPage(int offset, int limit, String productName, String productSize, Integer isDelete, Date startTime, Date endTime){
        Page page = productService.getProductPage(offset, limit, productName, productSize, isDelete, startTime, endTime);
        return new Result(page);
    }
}
