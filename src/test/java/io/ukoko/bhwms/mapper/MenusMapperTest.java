package io.ukoko.bhwms.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Menus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 菜单单元测试
 */
class MenusMapperTest extends BhWmsApplicationTests {

    @Autowired
    private MenusMapper menusMapper;

    @Test
    void getMenuList() throws JsonProcessingException {
        List<Menus> list = menusMapper.getMenuList();
        System.out.println(list);
    }

}