package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.dto.UserDto;
import io.ukoko.bhwms.entity.User;
import io.ukoko.bhwms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "用户模块")
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 获取用户详情
     */
    @GetMapping(value = "/getUserDetail")
    public Object getUserDetail(Integer userId){
        User user = userService.getUserByUserId(userId);
        return new Result(user);
    }

    /**
     * 添加用户
     */
    @PostMapping(value = "/addUser")
    public Object addUser(@RequestBody UserDto user){
        userService.addUser(user);
        return new Result();
    }

    /**
     * 获取用户列表
     */
    @GetMapping(value = "/getUserPage")
    public Object getUserPage(int pageNo, int pageSize, Integer isDelete, String userName,String userTel,String userEmail,String userNick, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime, Integer userId){
        Page page = userService.getUserPage(pageNo, pageSize, isDelete, userName, userTel, userEmail, userNick, startTime, endTime, userId);
        return new Result(page);
    }

    /**
     * 批量删除
     */
    @PostMapping(value = "/batchDeleteUser")
    public Object batchDeleteUser(@RequestBody List<Integer> userIds){
        userService.batchDeleteUser(userIds);
        return new Result();
    }

    /**
     * 更新用户
     */
    @PostMapping(value = "/updateUser")
    public Object updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new Result();
    }
}
