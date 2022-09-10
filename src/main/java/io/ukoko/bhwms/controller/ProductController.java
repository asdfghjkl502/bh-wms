package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品处理器
 */
@Api(tags = "商品管理模块控制器")
@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 获取产品列表
     * @param limit
     * @param offset
     * @param productName
     * @param categoryId
     * @param productPrice
     * @param productSize
     * @param productId
     * @param isDelete
     * @return
     */
    @GetMapping(value = "/getProductList")
    public Object getProductList(Integer limit,Integer offset,String productName,Integer categoryId,Double productPrice,String productSize,Integer productId,Integer isDelete){
        Page page = productService.getProductBy(limit, offset, productName, categoryId, productPrice, productSize, productId, isDelete);
        return new Result(page);
    }

    @GetMapping(value = "/deleteProduct")
    public Result deleteProduct(Integer productId){
        productService.deleteProduct(productId);
        return new Result();
    }

}
