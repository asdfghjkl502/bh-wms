package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库角色表(role)的接口类
 */
@Mapper
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
        通过角色ID查询角色信息
     */
    Role getRoleByRoleId(Integer roleId);

    /**
         批量删除
     */
    void batchDeleteRole(List<Integer> roleIds);

    /*
        查询角色列表
     */
    List<Role> getRoleList(@Param("roleName") String roleName,@Param("isDelete")Integer isDelete,@Param("roleId")Integer roleId,@Param("startTime")Date startTime,@Param("endTime")Date endTime);
}
