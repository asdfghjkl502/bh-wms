package io.ukoko.bhwms.service;

import io.ukoko.bhwms.entity.Category;
import io.ukoko.bhwms.exceptions.BhWmsException;

import java.util.List;

/**
 * 类目管理模块的业务逻辑层
 */
public interface CategoryService {
    /*
        添加类目
     */
    void addCategory(Category category);
    /*
        获取分类列表
     */
    List<Category> getCategoryList();
    /*
        更新
     */
    void updateCategory(Category category);

    /*
        删除
     */
    void deleteCategory(Integer categoryId) throws BhWmsException;
}
