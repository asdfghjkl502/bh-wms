package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Permission;

import java.util.List;

/**
 * 权限服务接口
 */
public interface PermissionService {

    /**
     * 添加权限
     */
    void addPermission(Permission permission);

    /**
     * 删除权限
     */
    void deletePermission(Integer permissionId);

    /**
     * 批量删除
     */
    void batchDeletePermission(List<Integer> permissionIds);

    /**
     * 更新权限
     */
    void updatePermission(Permission permission);

    /**
     * 分页查询权限
     */
    Page getPermissionPage(Integer pageNo, Integer pageSize, String permissionName, String permissionCode, Integer permissionType);

    /**
     * 获取所有权限
     */
    List<Permission> getPermissionAll();

    /**
     * 通过权限ID获取权限
     */
    Permission getPermissionByPermissionId(Integer permissionId);

    /**
     * 获取角色拥有的权限
     */
    List<Permission> getPermissionByRoleId(Integer roleId);

    /**
     * 分配权限给角色
     */
    void assignPermissions(Integer roleId, List<Integer> permissionIds);

    /**
     * 获取用户的菜单权限列表
     */
    List<Permission> getMenuPermissionsByUserId(Integer userId);

    /**
     * 获取用户的按钮权限代码列表
     */
    List<String> getButtonPermissionsByUserId(Integer userId);

    /**
     * 获取用户的API权限列表
     */
    List<String> getApiPermissionsByUserId(Integer userId);

    /**
     * 获取用户的所有权限（菜单+按钮+API）
     */
    List<Permission> getUserAllPermissions(Integer userId);
}
