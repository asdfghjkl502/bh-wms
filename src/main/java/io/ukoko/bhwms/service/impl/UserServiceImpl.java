package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.User;
import io.ukoko.bhwms.mapper.UserMapper;
import io.ukoko.bhwms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUserByUserId(Integer userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public Page getUserPage(int limit, int offset, Integer isDelete, String userName, String userTel, String userEmail, String userNick, Date startTime, Date endTime, Integer userId) {
        Page page = new Page();
        PageHelper.offsetPage(limit,offset);
        List<User> userList = userMapper.getUserList(userId, userName, userTel, userEmail, userNick, startTime, endTime, isDelete);
        PageInfo<User> info = new PageInfo<>(userList);
        page.setPageSize(info.getPageSize());
        page.setPageNo(info.getPageNum());
        page.setPageCount(info.getPages());
        page.setCount(info.getTotal());
        page.setHasNext(info.isHasNextPage());
        page.setHasPre(info.isHasPreviousPage());
        page.setData(info.getList());
        return page;
    }
}
