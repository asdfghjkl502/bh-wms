package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Role;

import java.awt.*;
import java.util.List;

/**
 * 角色管理模块的业务逻辑层
 */
public interface RoleService {

    /**
     * 添加角色
     * @param role 角色信息
     */
    void addRole(Role role);

    /**
     * 根据角色ID删除角色
     * @param roleId 角色ID
     */
    void deleteRoleByRoleId(Integer roleId);

    /**
     * 更新角色
     * @param role 角色信息
     */
    void updateRole(Role role);

    /**
     * 根据角色ID获取角色信息
     * @param roleId 角色ID
     * @return
     */
    Role getRoleByRoleId(Integer roleId);

    /**
     * 角色分页信息
     * @param pageNo 当前页
     * @param pageSize 每页显示多少条数
     * @param isDelete 是否删除 1:未删除 0:已删除
     * @return
     */
    Page getRolePage(int pageNo,int pageSize,int isDelete);


    /**
     * 角色分页信息
     * @param limit 每页显示多少条数
     * @param offset 偏移量
     * @param isDelete 是否删除 1:未删除 0:已删除
     * @return
     */
    Page getRolePageFor(int limit,int offset,int isDelete);

    /**
     * 获取 角色列表
     * @param isDelete 0:删除列表 1: 未删除列表 null: 全部(删除和未删除)
     * @return
     */
    List<Role> getRolesBy(Integer isDelete);
}
