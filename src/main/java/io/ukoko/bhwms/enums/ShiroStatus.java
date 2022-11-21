package io.ukoko.bhwms.enums;

/**
 * 认证的枚举常量
 */
public enum  ShiroStatus {

    LOGIN_OK(1000,"登录成功"),
    LOGIN_NOT_USER(1001,"用户参数不存在"),
    LOGIN_NOT_VC(1002,"验证码不存在"),
    LOGIN_ERROR_VC(1003,"验证码错误"),
    LOGIN_ERROR_USER(1004,"用户参数错误"),
    AUTHORIZATION_ERROR(1005,"权限不够"),
    LOGIN_ERROR(-1000,"登录失败")

    ;
    private int code;
    private String msg;

    ShiroStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    @Override
    public String toString() {
        return "ShiroStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
