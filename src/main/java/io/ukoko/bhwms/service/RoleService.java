package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Role;

import java.util.Date;
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
     * 获取角色分页
     * @param pageSize
     * @param pageNo
     * @param isDelete
     * @param roleName
     * @param startTime
     * @param endTime
     * @param roleId
     * @return
     */
    Page getRolePage(int pageSize,int pageNo,Integer isDelete,String roleName,Date startTime,Date endTime,Integer roleId);

    /**
     * 查询全部
     */
    List<Role> getRoleList();

    /**
     * 批量删除
     * @param roleIds 角色ID
     */
    void batchDeleteRole(List<Integer> roleIds);
}
