package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库菜单表(menu)的接口类
 */
@Mapper
public interface MenuMapper {

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
