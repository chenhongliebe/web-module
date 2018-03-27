package com.frico.website.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;

/**
 * Created by IntelliJ IDEA
 * User: Administrator
 * Date: 2018/3/20
 * Time: 15:20
 * Java gives me life and I have to work hard.
 */
@Slf4j
public
class MyInterceptor implements HandlerInterceptor{

    protected void setHeader(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }

    @Override
    public
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        setHeader(request, response);
        StringBuffer path = request.getRequestURL();
        log.info("请求地址：{}",path);
        if (path.indexOf("/login") != -1){
            log.info("login:"+request.getSession().getId());
            return true;
        }



        return true;
    }

    @Override
    public
    void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public
    void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
