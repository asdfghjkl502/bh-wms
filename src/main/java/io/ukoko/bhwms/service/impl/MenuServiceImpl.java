package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.Menu;
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
        menuMapper.deleteMenu(menuId);
    }

    @Override
    public List<Menu> getMenuList() {
        return menuMapper.getMenuList();
    }
}
