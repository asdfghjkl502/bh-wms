package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest extends BhWmsApplicationTests {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void addCategory() {


//        for (int i = 1; i <= 5; i++) {
//            Category category = new Category();
//            category.setCategoryName("一级类目标题"+i);
//            category.setCreateTime(new Date());
//            category.setIsDelete(1);
//            category.setLevel(1);
//            category.setParentId(0);
//
//            categoryMapper.addCategory(category);
//        }

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 2; i++) {
                Category category = new Category();
                category.setCategoryName("二级类目标题"+i);
                category.setCreateTime(new Date());
                category.setIsDelete(1);
                category.setLevel(2);
                category.setParentId(j);

                categoryMapper.addCategory(category);
            }
        }
    }

    @Test
    void getCategoryList() {
        categoryMapper.getCategoryList().forEach(System.out::println);
    }
}