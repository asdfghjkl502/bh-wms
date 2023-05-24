package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.Menu;
import io.ukoko.bhwms.exceptions.BhWmsException;
import io.ukoko.bhwms.mapper.MenuMapper;
import io.ukoko.bhwms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void addMenu(Menu menu) {
        menuMapper.addMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
    }

    @Override
    public void deleteMenu(Integer menuId) {
        //首先判断当前要删除的菜单下是否存在子菜单(未删除的子菜单)
        List<Menu> menus = menuMapper.getMenusByMenuId(menuId);
        if(menus!=null && menus.size()>0){
            //如果存在未删除的子菜单
            throw new BhWmsException(3,"存在子菜单,不能删除");
        }else {
            //删除
            menuMapper.deleteMenu(menuId);
        }
    }

    @Override
    public List<Menu> getMenuList() {
        return menuMapper.getMenuList();
    }

    @Override
    public List<Menu> getMenuList$() {
        return menuMapper.getMenuList$();
    }
}
