package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.Menus;
import io.ukoko.bhwms.mapper.MenusMapper;
import io.ukoko.bhwms.service.MenusSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MenusSerivceImpl implements MenusSerivce {

    @Autowired
    private MenusMapper menusMapper;

    @Override
    public List<Menus> getMenuList() {
        return menusMapper.getMenuList();
    }
}
