package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 分类
 */
class CategoryMapperTest extends BhWmsApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void addCategory() {
        for (int i = 0; i < 100; i++) {
            Category category = new Category("分类"+i,new Date(),1);
            categoryMapper.addCategory(category);
        }

    }
}