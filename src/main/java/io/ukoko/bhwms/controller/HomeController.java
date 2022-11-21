package io.ukoko.bhwms.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.exceptions.BhWmsException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

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
    @GetMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取验证码
        String text = defaultKaptcha.createText();
        System.out.println("验证码:"+text);
        //将验证码设置到Session对象中
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
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
     */
    @GetMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 登录
     */
    @ResponseBody
    @PostMapping(value = "/login")
    public Object login(@RequestBody Map<String,String> map,HttpServletRequest request){
        String userTel = map.get("userTel");
        String password = map.get("password");
        String vc = map.get("vc");
        Result result = new Result();
        /**
         * 验证验证码
         */
        if(vc==null || vc.length()==0){
            result.setCode(-1);
            result.setMsg("验证码不能为空");
        }else{
            //获取验证码
            String kaptcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(kaptcha==null || kaptcha.length()==0){
                throw new BhWmsException(-1,"验证码生成错误");
            }else{
                if(!vc.equals(kaptcha)){
                    //验证码错误
                    result.setCode(-1);
                    result.setMsg("验证码错误");
                }else{
                    if(userTel==null || password==null || userTel.length()==0 || password.length()==0){
                        /**
                         * 验证手机号和密码
                         */
                        result.setCode(-1);
                        result.setMsg("用户名或密码不存在");
                    }else {
                        //验证手机号和密码是否正确
                        UsernamePasswordToken token = new UsernamePasswordToken(userTel, password);
                        Subject subject = SecurityUtils.getSubject();
                        try {
                            subject.login(token);
                        }catch (AuthenticationException e) {
                            e.printStackTrace();
                            throw new BhWmsException(-2,"用户名或密码错误");
                        } catch (AuthorizationException e) {
                            e.printStackTrace();
                            throw new BhWmsException(-1,"权限不够");
                        }
                    }
                }
            }
        }
        return result;
    }
}
