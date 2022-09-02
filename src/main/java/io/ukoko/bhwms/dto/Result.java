package io.ukoko.bhwms.dto;

/**
 * API接口统一响应结果类型设置
 */
public class Result {
    /*
        响应状态码
     */
    private int code=0;
    /*
        响应消息
     */
    private String msg="OK";
    /*
        响应结果
     */
    private Object obj;

    public Result() {
    }

    public Result(Object obj) {
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
