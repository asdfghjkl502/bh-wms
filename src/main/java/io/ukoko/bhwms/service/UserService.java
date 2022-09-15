package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.User;

import java.util.Date;
import java.util.List;

/**
 * 用户管理模块的业务逻辑层
 */
public interface UserService {

    /**
     * 添加用户
     * @param user 用户信息
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param userId 用户ID
     */
    void deleteUserByUserId(Integer userId);

    /**
     * 更新用户
     * @param user 用户信息
     */
    void updateUser(User user);

    /**
     * 获取用户信息
     * @param userId 用户ID
     * @return
     */
    User getUserByUserId(Integer userId);

    /**
     * 用户分页信息
     * @param limit: 每页显示多少条数
     * @param offset: 偏移量
     * @param isDelete: 是是否有效 0:无效 1: 有效
     * @param userName: 用户名称
     * @param startTime: 开始时间
     * @param endTime : 结束时间
     * @param userId : 用户ID
     * @return
     */
    Page getUserPage(int limit, int offset, Integer isDelete, String userName, String userTel,String userEmail,String userNick,Date startTime, Date endTime, Integer userId);

}
