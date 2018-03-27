package com.frico.website.common;

import com.frico.website.common.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e.getClass() == MyException.class){
            MyException myException = (MyException) e;
            if(myException.getCode()==null || myException.getCode()==""){
                myException.setCode("1111");
            }
            log.info("自定义异常返回信息:{}",e.getMessage());
            return Result.ret(myException.getCode(),myException.getMessage());
        }else {
            log.error("系统异常：{}",e);
            return Result.ret("-1","系统错误");
        }
    }
}