package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库角色权限关联表(role_permission)的接口类
 */
@Mapper
public interface RolePermissionMapper {

    /**
     * 分配权限给角色
     */
    void assignPermissions(@Param("roleId") Integer roleId, @Param("permissionIds") List<Integer> permissionIds);

    /**
     * 删除角色所有权限关联
     */
    void deleteByRoleId(Integer roleId);

    /**
     * 批量删除角色权限关联
     */
    void batchDeleteByRoleId(List<Integer> roleIds);

    /**
     * 添加角色权限关联
     */
    void addRolePermission(RolePermission rolePermission);
}
