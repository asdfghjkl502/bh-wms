package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.UserDepartment;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;
import java.util.List;

/**
 * 操作数据库用户部门关联表(user_department)的接口类
 */
@Mapper
public interface UserDepartmentMapper {

    /**
     * 查询数据
     */
    List<UserDepartment> getUserDepartmentByUserId(Integer userId);
    /**
     * 插入数据
     */
    void addUserDepartment(UserDepartment userDepartment);
}
