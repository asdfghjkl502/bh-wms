package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Category;
import io.ukoko.bhwms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "类目模块")
@CrossOrigin
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    /**
     * 更新分类
     * @param category
     * @return
     */
    @PostMapping(value = "/updateCategory")
    public Object updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
        return new Result();
    }

    /**
     * 添加类目
     */
    @PostMapping(value = "/addCategory")
    public Object addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return new Result();
    }

    /**
     * 获取类目列表
     */
    @GetMapping(value = "/getCategoryList")
    public Object getCategoryList(){
        return new Result(categoryService.getCategoryList());
    }

}
