package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.User;
import org.apache.ibatis.annotations.Mapper;

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
     * 更新用户
     */
    void updateUser(User user);
    /**
     * 查询用户列表
     */
    List<User> getUserList(Integer userId, String userName, String userTel, String userEmail, String userNick, Date startTime,Date endTime,Integer isDelete);
    /**
     * 查询用户
     */
    User getUser(Integer userId);
}
