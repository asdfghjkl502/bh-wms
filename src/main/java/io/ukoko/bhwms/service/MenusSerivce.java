package io.ukoko.bhwms.service;

import io.ukoko.bhwms.entity.Menus;

import java.util.List;

/**
 * 菜单管理模块的业务逻辑层
 */
public interface MenusSerivce {
    /*
        通过父ID查询当前节点下的所有子节点
     */
    List<Menus> getMenuList();
}
