package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.entity.Menus;
import io.ukoko.bhwms.service.MenusSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单控制器
 */
@Api(tags = "菜单管理模块控制器")
@RestController
@CrossOrigin
public class MenusController {

    @Autowired
    private MenusSerivce menusSerivce;

    @GetMapping(value = "/getMenuList")
    public List<Menus> getMenuList(){
        List<Menus> menuList = menusSerivce.getMenuList();
        System.out.println("==>>"+menuList);
        return menuList;
    }

}
