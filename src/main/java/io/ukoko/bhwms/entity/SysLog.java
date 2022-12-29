package io.ukoko.bhwms.entity;

import java.util.Date;

/**
 * 映射数据库sys_log(日志)表
 */
public class SysLog {

    /*
        日志ID
     */
    private Long logId;
    /*
        日志类型
     */
    private Integer type;
    /*
        地址
     */
    private String ipAddr;
    /*
        方法名称
     */
    private String methodName;
    /*
        请求方式
     */
    private String method;
    /*
        昵称
     */
    private String nickName;
    /*
        创建时间
     */
    private Date createTime;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "logId=" + logId +
                ", type=" + type +
                ", ipAddr='" + ipAddr + '\'' +
                ", methodName='" + methodName + '\'' +
                ", method='" + method + '\'' +
                ", nickName='" + nickName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
