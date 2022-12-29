package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.SysLog;

import java.util.Date;
/**
 * 日志管理模块的业务逻辑层
 */
public interface SysLogService {

    /*
        插入日志
     */
    void addSysLog(SysLog sysLog);

    /**
     * 查询日志
     * @param pageNo
     * @param pageSize
     * @param type
     * @param methodName
     * @param method
     * @param nickName
     * @param start
     * @param end
     * @return
     */
    Page getSysLogPage(
                        Integer pageNo,
                        Integer pageSize,
                        Integer type,
                        String methodName,
                        String method,
                        String nickName,
                        Date start,
                        Date end);

}
