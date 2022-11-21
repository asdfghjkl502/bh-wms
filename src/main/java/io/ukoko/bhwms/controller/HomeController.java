package io.ukoko.bhwms.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.User;
import io.ukoko.bhwms.enums.ShiroStatus;
import io.ukoko.bhwms.exceptions.BhWmsException;
import io.ukoko.bhwms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 首页控制器
 * 登陆,注销,验证码生成,以及权限跳转的类
 */
@Api(tags = "首页模块")
@CrossOrigin
@Controller
public class HomeController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private UserService userService;

    /**
     * 生成验证码
     */
    @GetMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取验证码
        String text = defaultKaptcha.createText();
        //将验证码设置到Session对象中
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
        //生成图片
        BufferedImage image = defaultKaptcha.createImage(text);
        //将图片送到前端
        ImageIO.write(image,"jpg",response.getOutputStream());
    }


    /**
     * 注销
     */
    @GetMapping(value = "/logout")
    public String logout(HttpServletResponse response){
        //获取实体
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        //删除前端的cookie对象
        Cookie userId = new Cookie("userId", "");
        userId.setMaxAge(0);//让前端cookie立即失效
        Cookie userNick = new Cookie("userNick", "");
        userNick.setMaxAge(0);//让前端cookie立即失效
        response.addCookie(userId);
        response.addCookie(userNick);
        return "redirect:/toLogin";
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
     */
    @RequiresGuest
    @GetMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 登录
     */
    @RequiresGuest
    @ResponseBody
    @PostMapping(value = "/login")
    public Object login(@RequestBody Map<String,String> map,HttpServletRequest request,HttpServletResponse response){
        String userTel = map.get("userTel");
        String password = map.get("password");
        String vc = map.get("vc");
        Result result = new Result();
        /**
         * 验证验证码
         */
        if(vc==null || vc.length()==0){
            result = new Result(ShiroStatus.LOGIN_NOT_VC.getCode(),ShiroStatus.LOGIN_NOT_VC.getMsg());
        }else{
            //获取验证码
            String kaptcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(kaptcha==null || kaptcha.length()==0){
                throw new BhWmsException(ShiroStatus.LOGIN_NOT_VC);
            }else{
                if(!vc.equals(kaptcha)){
                    //验证码错误
                    result = new Result(ShiroStatus.LOGIN_ERROR_VC.getCode(),ShiroStatus.LOGIN_ERROR_VC.getMsg());
                }else{
                    if(userTel==null || password==null || userTel.length()==0 || password.length()==0){
                        /**
                         * 验证手机号和密码
                         */
                        throw new BhWmsException(ShiroStatus.LOGIN_NOT_USER);
                    }else {
                        //验证手机号和密码是否正确
                        UsernamePasswordToken token = new UsernamePasswordToken(userTel, password);
                        Subject subject = SecurityUtils.getSubject();
                        try {
                            subject.login(token);
                            //向前端保存数据
                            User user = userService.getUserByUserTel(userTel);
                            //将用户ID和用户昵称送到前端cookie中
                            response.addCookie(new Cookie("userId",user.getUserId()+""));
                            response.addCookie(new Cookie("userNick",user.getUserNick()));
                        }catch (AuthenticationException e) {
                            e.printStackTrace();
                            throw new BhWmsException(ShiroStatus.LOGIN_ERROR_USER);
                        } catch (AuthorizationException e) {
                            e.printStackTrace();
                            throw new BhWmsException(ShiroStatus.AUTHORIZATION_ERROR);
                        }catch (ShiroException e){
                            throw new BhWmsException(-1,"系统异常,请联系客服");
                        }
                    }
                }
            }
        }
        return result;
    }
}
