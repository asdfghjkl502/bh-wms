package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 */
@Api(tags = "首页模块")
@CrossOrigin
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
