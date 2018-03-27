package com.frico.website.common.exception;

public class MyException extends RuntimeException {

    private static final long serialVersionUID = 4457113998128457652L;

    private String code;

    private String message;

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
        this.message =message;
    }

    public MyException(String code,String message) {
        super(message);
        this.code = code;
        this.message =message;
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
        this.message =message;
    }

    public MyException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message =message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
