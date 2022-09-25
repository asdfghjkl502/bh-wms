package io.ukoko.bhwms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 */
@Controller
public class HomeController {

    /**
     * 首页跳转
     */
    @GetMapping(value = "/")
    public String index(){
        return "home";
    }

}
