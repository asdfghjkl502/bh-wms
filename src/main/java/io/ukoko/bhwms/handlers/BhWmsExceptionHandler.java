package io.ukoko.bhwms.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.enums.BhWmsStatus;
import io.ukoko.bhwms.enums.ShiroStatus;
import io.ukoko.bhwms.exceptions.BhWmsException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.naming.SizeLimitExceededException;

/**
 * 统一异常处理器
 */

@ControllerAdvice
public class BhWmsExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger("BH-WMS");

    @ResponseBody
    @ExceptionHandler(value = {BhWmsException.class})
    public Result departmentException(BhWmsException e){
        e.printStackTrace();//控制台异常消息打印
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMsg(e.getMessage());
        ObjectMapper om = new ObjectMapper();
        try {
            String json = om.writeValueAsString(result);
            LOGGER.error("异常消息为:{}",json);
        } catch (JsonProcessingException ex) {
            LOGGER.error("JSON解析异常:{}",ex.getMessage());
        }
        return result;
    }

    /**
     * 捕获用户登录异常
     */
    @ResponseBody
    @ExceptionHandler(value = {AuthorizationException.class})
    public Object authenticatedException(AuthorizationException e){
        e.printStackTrace();//控制台异常消息打印
        Result result = new Result(ShiroStatus.LOGIN_ERROR);
        return result;
    }


    /**
     * 捕获未认证异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {UnauthenticatedException.class})
    public String unauthenticatedExceptionException(UnauthenticatedException e){
        e.printStackTrace();//控制台异常消息打印
        return "redirect:/toLogin";
    }

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public Result commonException(Exception e){
        e.printStackTrace();//控制台异常消息打印
        Result result = new Result();
        result.setCode(BhWmsStatus.ERROR.getCode());
        if(e instanceof HttpRequestMethodNotSupportedException){
            result.setMsg(BhWmsStatus.REQUEST_NOT_METHOD.getMsg());
        } else if (e instanceof AuthenticationException) {
            result.setMsg(e.getMessage());
        } else if (e instanceof MaxUploadSizeExceededException) {
            result.setMsg(BhWmsStatus.FILE_MAX_ERROR.getMsg());
        } else {
            result.setMsg(BhWmsStatus.ERROR.getMsg());
        }
        ObjectMapper om = new ObjectMapper();
        try {
            String json = om.writeValueAsString(result);
            LOGGER.error("异常消息为:{}",json);
        } catch (JsonProcessingException ex) {
            LOGGER.error("JSON解析异常:{}",ex.getMessage());
        }
        return result;
    }

}
