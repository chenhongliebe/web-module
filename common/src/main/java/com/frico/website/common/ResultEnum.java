package com.frico.website.common;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public enum ResultEnum {
    SUCCESS("0","success"),
    FAIL("1","fail"),
    SYS_ERROR("10001","系统异常");

    private String code;
    private String msg;

    private ResultEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
