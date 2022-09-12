package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Menus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库菜单表(menus)的接口类
 */
@Mapper
public interface MenusMapper {

    /*
        查询父级列表
     */
    List<Menus> getMenuList();
}
