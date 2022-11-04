package io.ukoko.bhwms.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.exceptions.BhWmsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理器
 */
@ResponseBody
@ControllerAdvice
public class BhWmsExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger("BH-WMS");

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

    @ExceptionHandler(value = {Exception.class})
    public Result commonException(Exception e){
        e.printStackTrace();//控制台异常消息打印
        Result result = new Result();
        result.setCode(-1);
        result.setMsg("系统异常");
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
