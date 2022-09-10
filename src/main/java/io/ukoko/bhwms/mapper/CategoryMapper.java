package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作数据库分类表(category)的接口类
 */
@Mapper
public interface CategoryMapper {

    /**
     * 添加分类
     * @param category
     */
    void addCategory(Category category);

    /**
     * 通过分类ID获取分类信息
     * @param categoryId
     * @return
     */
    Category getCategoryByCategoryId(Integer categoryId);
}
