package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
/**
 * 操作数据库用户表(user)的接口类
 */
@Mapper
public interface UserMapper {

    /**
     * 添加用户
     */
    void addUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(Integer userId);

    /**
     * 批量删除
     */
    void batchDeleteUser(List<Integer> userIds);

    /**
     * 批量查询
     */
    List<User> batchGetUserList(List<Integer> userIds);

    /**
     * 更新用户
     */
    void updateUser(User user);
    /**
     * 查询用户列表
     */
    List<User> getUserList(@Param("userId") Integer userId,@Param("userName") String userName, @Param("userTel") String userTel,@Param("userEmail") String userEmail,@Param("userNick") String userNick,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("isDelete") Integer isDelete);
    /**
     * 查询用户
     */
    User getUser(Integer userId);

    /**
     * 通过用户手机号获取用户信息
     */
    User getUserByUserTel(String userTel);
}
