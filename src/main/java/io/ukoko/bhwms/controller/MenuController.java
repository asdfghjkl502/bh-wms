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
