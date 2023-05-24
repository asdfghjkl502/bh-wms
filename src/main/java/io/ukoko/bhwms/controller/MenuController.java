package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Menu;
import io.ukoko.bhwms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "菜单模块")
@CrossOrigin
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单列表(包含叶子节点)
     */
    @GetMapping(value = "/getMenuList$")
    public Object getMenuList$(){
        return new Result(menuService.getMenuList$());
    }

    /*
        删除菜单
     */
    @GetMapping(value = "/deleteMenu")
    public Object deleteMenu(Integer menuId){
        menuService.deleteMenu(menuId);
        return new Result();
    }

    /*
        更新菜单
     */
    @PostMapping(value = "/updateMenu")
    public Object updateMenu(@RequestBody Menu menu) {
        menuService.updateMenu(menu);
        return new Result();
    }

    /*
        添加菜单
     */
    @PostMapping(value = "/addMenu")
    public Object addMenu(@RequestBody Menu menu){
        menuService.addMenu(menu);
        return new Result();
    }

    /*
        获取部门列表
     */
    @GetMapping(value = "/getMenuList")
    public Object getMenuList(){
        return new Result(menuService.getMenuList());
    }
}
