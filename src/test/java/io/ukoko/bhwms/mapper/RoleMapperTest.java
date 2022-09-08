package io.ukoko.bhwms.mapper;

import com.github.pagehelper.PageHelper;
import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest extends BhWmsApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void addRole() {
        for (int i = 0; i < 100; i++) {
            roleMapper.addRole(new Role(null,"普通角色"+i));
        }

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
        PageHelper.offsetPage(0,5);
        roleMapper.getRoleList(1).forEach(System.out::println);
    }

    @Test
    void getRoleBy() {
        Role role = roleMapper.getRoleBy(1);
        System.out.println(role);
    }

    @Test
    void getRoleListLike(){
        PageHelper.startPage(1,2);
        List<Role> roles = roleMapper.getRoleListLike("0", 1);
        for (Role role : roles) {
            System.out.println(role);
        }

    }
}