package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "用户模块")
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @param limit
     * @param offset
     * @param isDelete
     * @param userName
     * @param userTel
     * @param userEmail
     * @param userNick
     * @param startTime
     * @param endTime
     * @param userId
     * @return
     */
    @GetMapping(value = "/getUserList")
    public Object getUserList(int limit, int offset, Integer isDelete, String userName,String userTel,String userEmail,String userNick, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime, Integer userId){
        Page page = userService.getUserPage(limit, offset, isDelete, userName, userTel, userEmail, userNick, startTime, endTime, userId);
        return new Result(page);
    }

}
