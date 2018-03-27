package com.frico.website.web;


import com.frico.website.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA
 * User: Administrator
 * Date: 2018/3/20
 * Time: 14:43
 * Java gives me life and I have to work hard.
 */
@RestController
@RequestMapping("home")
public class HomeController {

//    @Autowired
//    private
//    VideoMapper videoMapper;

    @RequestMapping("demo")
    public
    Result demo(){
        System.out.println("hello world");
        System.out.print("1111");
        System.out.print("2222");
        return Result.success();
    }

//    @RequestMapping("getVideo")
//    public Result getVideo(Integer integer){
//        Video video = videoMapper.selectByPrimaryKey(integer);
//        return Result.success(video);
//    }

}
