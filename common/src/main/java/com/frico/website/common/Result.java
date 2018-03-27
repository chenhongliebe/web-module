package com.frico.website.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 4160748732980096229L;

    private String code;

    private String msg;

    private T data;

    public Result(){
    }

    public Result(ResultEnum resultEnum){
        this.code=resultEnum.getCode();
        this.msg=resultEnum.getMsg();
    }

    public Result(String code,String msg){
        this.code=code;
        this.msg = msg;
    }


    public Result(T data){
        this.code=ResultEnum.SUCCESS.getCode();
        this.msg=ResultEnum.SUCCESS.getMsg();
        this.data=data;
    }

    public static<T> Result<T> success(T data){
        return new Result(data);
    }

    public static<T> Result<T> success(String code,String msg){

        return new Result(code,msg);
    }

    public static<T> Result<T> success(){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static<T> Result<T> ret(ResultEnum resultEnum){
        return new Result(resultEnum);
    }

    public static<T> Result<T> ret(String code,String msg){
        return new Result(code,msg);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
