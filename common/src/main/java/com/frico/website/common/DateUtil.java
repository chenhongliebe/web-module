package com.frico.website.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * 创建一个获取随机数的公共类
 * User: xrb
 * Date: 2018/3/21
 * Time: 18:08
 * Java gives me life and I have to work hard.
 */
public class DateUtil {

    public static String getManyString(int num){

        String baseString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<num; i++){
            //随机获取一个字符
            int n = random.nextInt(baseString.length());
            sb.append(baseString.charAt(n));
        }

        return sb.toString();
    }


    //获取当前时间的毫秒数
    public static String getTimeString(){
        return new SimpleDateFormat("HHmmSS").format(new Date());
    }


    public static void main(String[] args) {

        for (int i=0; i<10; i++){
            System.out.println(getManyString(10) + getTimeString());
        }
    }

}



























