package com.frico.website.common;

import com.frico.website.common.model.LoginInfo;

public class UserUtil {

    public static final ThreadLocal<LoginInfo> threadLocal = new ThreadLocal<>();

    public static void setLoginInfo(LoginInfo loginInfo){
        threadLocal.set(loginInfo);
    }

    public static LoginInfo getLoginInfo(){
        return threadLocal.get();
    }
}
