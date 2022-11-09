package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.Category;
import io.ukoko.bhwms.exceptions.BhWmsException;
import io.ukoko.bhwms.mapper.CategoryMapper;
import io.ukoko.bhwms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) throws BhWmsException{
        //判断当前分类下是否存在叶子节点,如果存在不能删除
        List<Category> categories = categoryMapper.getCategoryListByParentId(categoryId);
        if(categories!=null && categories.size()>0){
            throw new BhWmsException(3,"存在叶子节点,不能删除");
        }else{
            categoryMapper.deleteCategory(categoryId);
        }
    }
}
