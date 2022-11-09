package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库类目表(category)的接口类
 */
@Mapper
public interface CategoryMapper {

    /*
        添加类目
     */
    void addCategory(Category category);
    /*
        获取分类列表
     */
    List<Category> getCategoryList();

    /*
        查询单个
     */
    Category getCategory(Integer categoryId);

    /*
        更新
     */
    void updateCategory(Category category);

    /*
        删除
     */
    void deleteCategory(Integer categoryId);
}
