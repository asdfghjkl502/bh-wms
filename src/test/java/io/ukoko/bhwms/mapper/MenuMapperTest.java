package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MenuMapperTest extends BhWmsApplicationTests {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void addMenu() {
//        for (int i = 1; i <= 5; i++) {
//            Menu menu = new Menu();
//            menu.setMenuName("顶级菜单标题"+i);
//            menu.setLevel(1);
//            menu.setParentId(0);
//            menu.setCreateTime(new Date());
//            menu.setIsDelete(1);
//            menuMapper.addMenu(menu);
//        }

        for (int i = 1; i <= 2; i++) {
            Menu menu = new Menu();
            menu.setMenuName("子集菜单标题"+i);
            menu.setLevel(1);
            menu.setParentId(5);
            menu.setCreateTime(new Date());
            menu.setIsDelete(1);
            menuMapper.addMenu(menu);
        }

    }

    @Test
    void getMenuList() {
    }
}