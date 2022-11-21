package io.ukoko.bhwms.enums;

/**
 * 百惠项目状态码
 */
public enum  BhWmsStatus {

    OK(0,"成功"),
    FILE_ERROR(1,"文件上传失败"),
    FILE_STYLE_ERROR(2,"文件格式不支持"),


    ERROR(-1,"系统异常,请联系管理员")
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
