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
        获取分类列表(用于前端下拉数据展示)
     */
    List<Category> getCategoryList$();


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

    /**
     * 通过ID查询当前id下是否存在子节点
     * @param categoryId
     * @return
     */
    List<Category> getCategoryListByParentId(Integer categoryId);
}
