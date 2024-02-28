package com.novelnet.demo.controller;

import com.novelnet.demo.pojo.Result;
import com.novelnet.demo.pojo.User;
import com.novelnet.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * 登录方法
     * 需要参数：account-账号、password-密码
     * 状态码：200-成功， 401-用户名或密码错误
     */
    @PostMapping("/login")
    public Result login(@RequestParam("account") String account, @RequestParam("password") String password, HttpSession session){
        String token = iUserService.login(account, password, session);
        if(token != null){
            return new Result(200, token, "LOGIN OK!!!");
        }
        return new Result(401, null, "LOGIN ERROR: 用户名或密码错误");
    }

    /**
     * 注册方法
     * 需要参数：JSON对象，对应User
     * 状态码：201-注册成功、403-用户已存在、400-注册失败
     */
    @PostMapping("/enroll")
    public Result enroll(@RequestBody User user){
        int i = iUserService.enroll(user);
        if(i == 1){
            return new Result(201, null, "ENROLL OK!!!");
        }else if(i == -1){
            return new Result(403, null, "ENROLL ERROR: 该用户已存在");
        }else {
            return new Result(400, null, "ENROLL ERROR: 注册失败");
        }
    }

    /**
     * 找回密码方法，返回密码字符串
     * 需要参数：account-账号、email-邮箱
     * 200-成功，返回旧密码、404-失败，用户名邮箱或许错误
     */
    @PostMapping("/retrievePassword")
    public Result retrievePassword(@RequestParam("account") String account, @RequestParam("email") String email){
        String password = iUserService.getPassword(account, email);
        if (password == null){
            return new Result(404, null, "retrievePassword ERROR: 请检查用户名邮箱是否正确");
        }
        return new Result(200, password, "retrievePassword OK!!!");
    }
}