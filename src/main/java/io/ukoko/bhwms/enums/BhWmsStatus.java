package io.ukoko.bhwms.enums;

/**
 * 百惠项目状态码
 */
public enum  BhWmsStatus {

    OK(0,"成功"),
    FILE_ERROR(1,"文件上传失败"),
    FILE_STYLE_ERROR(2,"暂时不支持的文件格式"),
    FILE_MAX_ERROR(3,"文件过大"),
    REQUEST_NOT_METHOD(4,"请求方式错误"),
    REPO_NOT_PARAM(5,"仓库参数不存在"),
    REPO_NOT_STOCK(6,"库存不足"),
    REPO_NOT_PRODUCT(7,"当前仓库没有此产品"),


    LOGIN_ERROR(8,"登陆失败"),

    ERROR(-1,"系统异常")
    ;
    private int code;
    private String msg;

    BhWmsStatus(int code, String msg) {
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
        return "BhWmsStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
