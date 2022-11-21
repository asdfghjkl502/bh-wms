package io.ukoko.bhwms.exceptions;

import io.ukoko.bhwms.enums.BhWmsStatus;
import io.ukoko.bhwms.enums.ShiroStatus;

/**
 * @Auther: hushuang
 * @Date: 2022/10/29 13:23
 * @Description:
 */
public class BhWmsException extends RuntimeException{
    private int code=0;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BhWmsException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BhWmsException(ShiroStatus shiroStatus) {
        super(shiroStatus.getMsg());
        this.code = shiroStatus.getCode();
    }
    public BhWmsException(BhWmsStatus status) {
        super(status.getMsg());
        this.code = status.getCode();
    }
}
