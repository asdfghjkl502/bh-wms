package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作数据库日志表(sys_log)的接口类
 */
@Mapper
public interface SysLogMapper {

    /*
        插入日志
     */
    void addSysLog(SysLog sysLog);

}
