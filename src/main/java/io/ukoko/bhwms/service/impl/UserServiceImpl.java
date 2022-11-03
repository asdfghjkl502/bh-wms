package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.UserDto;
import io.ukoko.bhwms.entity.User;
import io.ukoko.bhwms.entity.UserDepartment;
import io.ukoko.bhwms.entity.UserRole;
import io.ukoko.bhwms.mapper.UserDepartmentMapper;
import io.ukoko.bhwms.mapper.UserMapper;
import io.ukoko.bhwms.mapper.UserRoleMapper;
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
    @Autowired
    private UserDepartmentMapper userDepartmentMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public void addUser(UserDto user) {
        User u = new User();
        u.setUserName(user.getUserName());
        u.setUserTel(user.getUserTel());
        u.setUserEmail(user.getUserEmail());
        u.setUserNick(user.getUserNick());
        u.setPassword(user.getPassword());
        u.setSalt(user.getSalt());
        u.setCreateTime(user.getCreateTime());
        u.setIsDelete(user.getIsDelete());
        //用户表添加数据
        userMapper.addUser(u);
        //用户部门中间表添加数据
        List<Integer> deptId = user.getDeptId();
        if(deptId!=null && deptId.size()>0){
            for (Integer dId : deptId) {
                UserDepartment userDepartment = new UserDepartment();
                userDepartment.setDeptId(dId);
                userDepartment.setUserId(u.getUserId());
                userDepartment.setCreateTime(u.getCreateTime());
                userDepartment.setIsDelete(u.getIsDelete());
                userDepartmentMapper.addUserDepartment(userDepartment);
            }
        }
        //用户角色中间表添加数据
        List<Integer> roleId = user.getRoleId();
        if(roleId!=null && roleId.size()>0){
            for (Integer rId : roleId) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(rId);
                userRole.setUserId(u.getUserId());
                userRole.setCreateTime(u.getCreateTime());
                userRole.setIsDelete(u.getIsDelete());
                userRoleMapper.addUserRole(userRole);
            }
        }
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
    public Page getUserPage(int pageNo, int pageSize, Integer isDelete, String userName, String userTel, String userEmail, String userNick, Date startTime, Date endTime, Integer userId) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
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

    @Override
    public void batchDeleteUser(List<Integer> userIds) {
        userMapper.batchDeleteUser(userIds);
    }


}
