package io.ukoko.bhwms.handlers;

import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.exceptions.BhWmsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理器
 */
@ResponseBody
@ControllerAdvice
public class BhWmsExceptionHandler {


    @ExceptionHandler(value = {BhWmsException.class})
    public Result departmentException(BhWmsException e){
        e.printStackTrace();//控制台异常消息打印
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = {Exception.class})
    public Result commonException(Exception e){
        e.printStackTrace();//控制台异常消息打印
        Result result = new Result();
        result.setCode(-1);
        result.setMsg("系统异常");
        return result;
    }

}
