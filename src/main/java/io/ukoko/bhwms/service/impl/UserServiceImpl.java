package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.UserDto;
import io.ukoko.bhwms.entity.*;
import io.ukoko.bhwms.mapper.UserDepartmentMapper;
import io.ukoko.bhwms.mapper.UserMapper;
import io.ukoko.bhwms.mapper.UserRoleMapper;
import io.ukoko.bhwms.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
        //生成盐值
        String salt = Math.random()+"";
        u.setSalt(salt);
        //通过盐值生成密码
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        String pwd = md5Hash.toString();
        u.setPassword(pwd);
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
        if(user.getPassword()!=null && user.getPassword()!=""){
            //通过ID查询盐值
            User u = userMapper.getUser(user.getUserId());
            //盐值
            String salt = u.getSalt();
            //获取原密码
            String password = user.getPassword();
            //加密
            Md5Hash md5Hash = new Md5Hash(password, salt, 1024);
            //加密之后的密码
            String newPwd = md5Hash.toString();
            user.setPassword(newPwd);
        }
        userMapper.updateUser(user);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        User user = userMapper.getUser(userId);
        List<Department> ds = new ArrayList<>();
        List<Role> rs = new ArrayList<>();
        List<UserDepartment> userDepartments = userDepartmentMapper.getUserDepartmentByUserId(user.getUserId());
        for (UserDepartment ud : userDepartments) {
            ds.add(ud.getDepartment());
        }
        List<UserRole> userRoles = userRoleMapper.getUserRoleByUserId(user.getUserId());
        for (UserRole ur : userRoles) {
            rs.add(ur.getRole());
        }
        user.setDepartments(ds);
        user.setRoles(rs);
        return user;
    }

    @Override
    public User getUserByUserTel(String userTel) {
        User user = userMapper.getUserByUserTel(userTel);
        List<Department> ds = new ArrayList<>();
        List<Role> rs = new ArrayList<>();
        List<UserDepartment> userDepartments = userDepartmentMapper.getUserDepartmentByUserId(user.getUserId());
        for (UserDepartment ud : userDepartments) {
            ds.add(ud.getDepartment());
        }
        List<UserRole> userRoles = userRoleMapper.getUserRoleByUserId(user.getUserId());
        for (UserRole ur : userRoles) {
            rs.add(ur.getRole());
        }
        user.setDepartments(ds);
        user.setRoles(rs);
        return user;
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

        for (User user : userList) {
            List<Department> ds = new ArrayList<>();
            List<Role> rs = new ArrayList<>();
            List<UserDepartment> userDepartments = userDepartmentMapper.getUserDepartmentByUserId(user.getUserId());
            for (UserDepartment ud : userDepartments) {
                ds.add(ud.getDepartment());
            }
            user.setDepartments(ds);
            List<UserRole> userRoles = userRoleMapper.getUserRoleByUserId(user.getUserId());
            for (UserRole ur : userRoles) {
                rs.add(ur.getRole());
            }
            user.setRoles(rs);
        }
        page.setData(userList);
        return page;
    }

    @Override
    public void batchDeleteUser(List<Integer> userIds) {
        userMapper.batchDeleteUser(userIds);
    }


    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("1","1",1024);
        System.out.println(md5Hash.toString());
    }
}
