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
        查询角色列表
        isDelete: 是否删除 1: 未删除 0:已删除
     */
    List<Role> getRoleList(Integer isDelete);
    /*
        通过角色ID查询角色信息
     */
    Role getRoleBy(Integer roleId);

    /**
     * 搜索
     * @param roleName: 搜索条件
     * @param isDelete: 是否删除 1: 未删除 0:已删除
     * @return
     */
    List<Role> getRoleListLike(@Param("roleName") String roleName,@Param("isDelete") Integer isDelete);

    List<Role> getRolesByParam(@Param("roleName") String roleName, @Param("isDelete") Integer isDelete, @Param("startTime") Date startTime,@Param("endTime")Date endTime);

}
