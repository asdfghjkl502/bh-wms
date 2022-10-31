package io.ukoko.bhwms.service;

import io.ukoko.bhwms.entity.Menu;

import java.util.List;

/**
 * 菜单管理模块的业务逻辑层
 */
public interface MenuService {
    /*
        添加菜单
     */
    void addMenu(Menu menu);

    /*
        更新菜单
     */
    void updateMenu(Menu menu);

    /*
        删除菜单
     */
    void deleteMenu(Integer menuId);

    /*
        获取菜单列表
     */
    List<Menu> getMenuList();

}
