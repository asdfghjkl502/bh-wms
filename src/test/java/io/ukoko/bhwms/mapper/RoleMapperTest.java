package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest extends BhWmsApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void addRole() {
        Role role = new Role();
        role.setRoleName("测试角色名称");
        role.setIsDelete(1);
        role.setCreateTime(new Date());
        roleMapper.addRole(role);
    }

    @Test
    void deleteRole() {
        roleMapper.deleteRole(1);
    }

    @Test
    void updateRole() {
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("测试角色名称001");
        role.setIsDelete(1);
        role.setCreateTime(new Date());
        roleMapper.updateRole(role);
    }

    @Test
    void getRoleByRoleId() {
        Role role = roleMapper.getRoleByRoleId(1);
        System.out.println(role);
    }

    @Test
    void batchDeleteRole() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        roleMapper.batchDeleteRole(ids);
    }

    @Test
    void getRoleList() {
        roleMapper.getRoleList(null,1,null,null,null).forEach(System.out::println);
    }
}