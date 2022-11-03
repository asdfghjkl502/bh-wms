package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库用户角色关联表(user_role)的接口类
 */
@Mapper
public interface UserRoleMapper {
    /**
     * 查询数据
     */
    List<UserRole> getUserRoleByUserId(Integer userId);
    /**
     * 插入数据
     */
    void addUserRole(UserRole userRole);
}
