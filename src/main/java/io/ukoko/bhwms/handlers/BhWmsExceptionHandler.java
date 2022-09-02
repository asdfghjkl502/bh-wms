package io.ukoko.bhwms.handlers;

import io.ukoko.bhwms.dto.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理器
 */
@ResponseBody
@ControllerAdvice
public class BhWmsExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public Result commonException(Exception e){
        Result result = new Result();
        result.setCode(-1);
        result.setMsg("系统异常");
        return result;
    }

}
