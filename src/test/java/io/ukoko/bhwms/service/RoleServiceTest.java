package io.ukoko.bhwms.service;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.dto.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: hushuang
 * @Date: 2022/9/2 21:45
 * @Description:
 */
class RoleServiceTest extends BhWmsApplicationTests {

    @Autowired
    private RoleService roleService;

    @Test
    void addRole() {
    }

    @Test
    void deleteRoleByRoleId() {
    }

    @Test
    void updateRole() {
    }

    @Test
    void getRoleByRoleId() {
    }

    @Test
    void getRolePage() {
        Page page = roleService.getRolePage(2, 1, 1);
        System.out.println(page);
    }
}