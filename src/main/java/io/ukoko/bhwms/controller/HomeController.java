package io.ukoko.bhwms.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 首页控制器
 */
@Api(tags = "首页模块")
@CrossOrigin
@Controller
public class HomeController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /**
     * 生成验证码
     */
    @RequiresGuest //匿名访问
    @GetMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpSession session, HttpServletResponse response) throws IOException {
        //获取验证码
        String text = defaultKaptcha.createText();
        System.out.println("验证码:"+text);
        //将验证码设置到Session对象中
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
        //生成图片
        BufferedImage image = defaultKaptcha.createImage(text);
        //将图片送到前端
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    /**
     * 首页跳转
     */
    @RequiresAuthentication /*需要认证*/
    @GetMapping(value = "/")
    public String home(){
        return "home";
    }

    /**
     * 跳转登录页
     * @return
     */
    @RequiresGuest /* 匿名 */
    @GetMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }
}
