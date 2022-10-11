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
     * 角色分页信息
     * @param limit: 每页显示多少条数
     * @param offset: 偏移量
     * @param isDelete: 是是否有效 0:无效 1: 有效
     * @param roleName: 角色名称
     * @param startTime: 开始时间
     * @param endTime : 结束时间
     * @param roleId : 角色ID
     * @return
     */
    Page getRolePageFor(int limit,int offset,Integer isDelete,String roleName,Date startTime,Date endTime,Integer roleId);

    Page getRolePage(int pageSize,int pageNo,Integer isDelete,String roleName,Date startTime,Date endTime,Integer roleId);


    /**
     * 批量删除
     * @param roleIds 角色ID
     */
    void batchDeleteRole(List<Integer> roleIds);
}
