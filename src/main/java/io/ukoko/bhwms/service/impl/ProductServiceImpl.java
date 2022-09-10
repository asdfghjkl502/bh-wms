package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Product;
import io.ukoko.bhwms.mapper.ProductMapper;
import io.ukoko.bhwms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品模块管理的业务逻辑层
 */
@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page getProductBy(Integer limit, Integer offset, String productName, Integer categoryId, Double productPrice, String productSize, Integer productId,Integer isDelete) {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setCategoryId(categoryId);
        product.setIsDelete(isDelete);
        product.setProductSize(productSize);
        PageHelper.offsetPage(offset,limit);
        List<Product> productList = productMapper.getProductList(product);
        PageInfo<Product> info = new PageInfo<>(productList);
        Page page = new Page();
        page.setData(info.getList());
        page.setCount(info.getTotal());
        page.setPageCount(info.getPages());
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setHasNext(info.isHasNextPage());
        page.setHasPre(info.isHasPreviousPage());
        return page;
    }

    @Override
    public void deleteProduct(Integer productId) {
        productMapper.deleteProduct(productId);
    }
}
