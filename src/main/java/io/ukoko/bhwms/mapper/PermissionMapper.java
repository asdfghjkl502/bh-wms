package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库权限表(permission)的接口类
 */
@Mapper
public interface PermissionMapper {

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
     * 获取权限列表
     */
    List<Permission> getPermissionList(@Param("permissionName") String permissionName,
                                       @Param("permissionCode") String permissionCode,
                                       @Param("permissionType") Integer permissionType);

    /**
     * 获取所有权限
     */
    List<Permission> getPermissionAll();

    /**
     * 通过权限ID查询
     */
    Permission getPermissionByPermissionId(Integer permissionId);

    /**
     * 通过角色ID获取权限列表
     */
    List<Permission> getPermissionByRoleId(Integer roleId);

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
}
