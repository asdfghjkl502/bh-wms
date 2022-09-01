package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Role;

import java.util.List;

/**
 * 操作数据库角色表(role)的接口类
 */
public interface RoleMapper {
    /*
        添加角色
     */
    void addRole(Role role);

    /*
        删除角色
     */
    void deleteRole(Integer roleId);
    /*
        更新角色
     */
    void updateRole(Role role);
    /*
        查询角色列表
     */
    List<Role> getRoleList();
    /*
        通过角色ID查询角色信息
     */
    Role getRoleBy(Integer roleId);
}
