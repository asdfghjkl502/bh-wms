package io.ukoko.bhwms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 首页控制器
 */
@Controller
public class HomeController {

    /**
     * 跳转网站首页(登录页)
     * @return
     */
    @GetMapping(value = "/")
    public String toLogin(){
        System.out.println("登录页...");
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @PostMapping(value = "/login")
    public String login(){
        System.out.println("登录 SUCCESS ...");
        return "redirect:/home";
    }

    /**
     * 跳转home页面
     * @return
     */
    @GetMapping(value = "/home")
    public String toHome(){
        System.out.println("跳转home页...");
        return "home";
    }
}
