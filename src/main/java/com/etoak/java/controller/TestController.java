package com.etoak.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/***
 * @Author 高俊 QQ:1120934832
 * @Slogan 易途科技，精英启航
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/login")
    public String login(@RequestParam Map<String,Object> param){
        String username = (String)param.get("username");
        String password = (String)param.get("password");
        System.out.println("当前登录的用户名是：" + username);
        System.out.println("当前登录的用户密码是：" + password);
        return "登录成功！";
    }
}
