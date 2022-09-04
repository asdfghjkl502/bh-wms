package io.ukoko.bhwms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
