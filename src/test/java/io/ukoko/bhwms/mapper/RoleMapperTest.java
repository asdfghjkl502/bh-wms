package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest extends BhWmsApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void addRole() {
        roleMapper.addRole(new Role(null,"库管"));
    }

    @Test
    void deleteRole() {
        roleMapper.deleteRole(1);
    }

    @Test
    void updateRole() {
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("平台管理员");
        role.setIsDelete(1);
        roleMapper.updateRole(role);
    }

    @Test
    void getRoleList() {
        roleMapper.getRoleList(1).forEach(System.out::println);
    }

    @Test
    void getRoleBy() {
        Role role = roleMapper.getRoleBy(1);
        System.out.println(role);
    }
}