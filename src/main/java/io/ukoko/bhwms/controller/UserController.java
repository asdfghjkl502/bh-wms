package io.ukoko.bhwms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 用户模块控制器
 */
@Controller
public class UserController {

    /**
     * 用户登录
     */
    @PostMapping(value = "/login")
    public String login(){
        System.out.println("跳转首页...");
        return "home";
    }

}
