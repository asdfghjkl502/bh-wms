package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库日志表(sys_log)的接口类
 */
@Mapper
public interface SysLogMapper {

    /*
        插入日志
     */
    void addSysLog(SysLog sysLog);

    /**
     * 查询日志
     * @param type
     * @param methodName
     * @param method
     * @param nickName
     * @param start
     * @param end
     * @return
     */
    List<SysLog> getSysLogList(@Param("type") Integer type,
                               @Param("methodName") String methodName,
                               @Param("method") String method,
                               @Param("nickName") String nickName,
                               @Param("start") Date start,
                               @Param("end") Date end);
}
