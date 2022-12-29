package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "日志模块")
@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping(value = "/getLogs")
    public Object getLogs(Integer pageNo,
                          Integer pageSize,
                          Integer type,
                          String methodName,
                          String method,
                          String nickName,
                          Date start,
                          Date end){

        Page page = sysLogService.getSysLogPage(pageNo, pageSize, type, methodName, method, nickName, start, end);
        return new Result(page);
    }

}
