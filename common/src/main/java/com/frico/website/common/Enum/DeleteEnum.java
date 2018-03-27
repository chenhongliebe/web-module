package com.frico.website.common.Enum;

public enum DeleteEnum {
    DELETED("1","已删除"),
    NOT_DELETE("0","未删除");

    private String code;
    private String msg;

    DeleteEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
