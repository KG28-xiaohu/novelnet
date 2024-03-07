package com.novelnet.demo.controller;

import com.novelnet.demo.pojo.Result;
import com.novelnet.demo.pojo.User;
import com.novelnet.demo.service.IUserService;
import com.novelnet.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public Result login(String account, String password){
        User user = iUserService.login(account, password);
        if (user != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            String token = TokenUtil.makeToken(map);
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
        user.setUsername(user.getAccount());
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
     * 200-成功，允许进行修改、404-失败，用户名或邮箱错误
     */
    @PostMapping("/retrievePassword")
    public Result retrievePassword(String account, String email){
        String password = iUserService.getPassword(account, email);
        if (password == null){
            return new Result(404, null, "retrievePassword ERROR: 请检查用户名邮箱是否正确");
        }
        return new Result(200, null, "retrievePassword OK!!!");
    }

    /**
     * 修改密码的方法（需要登录以后）
     * 需要参数：password-原密码、newPassword-新密码
     * 200-修改密码成功、400-修改密码失败，原密码错误
     */
    @PostMapping("/token/updatePassword")
    public Result updatePassword(String password, String newPassword, HttpSession session){
        User user = (User)session.getAttribute("user");
        return iUserService.updatePassword(user.getUid(), password, newPassword) > 0 ?
                new Result(200, null, "updatePassword OK!!!") :
                new Result(400, null, "updatePassword ERROR: 原密码错误");
    }

    /**
     * 获取用户详细信息
     * 需要参数：account-账号、password-密码
     * 200-获取成功
     */
    @PostMapping("/token/getUser")
    public Result getUserByAccount(String account, String password){
        User user = iUserService.login(account, password);
        if (user != null) {
            return new Result(200, user, "LOGIN OK!!!");
        }
        return new Result(401, null, "LOGIN ERROR: 用户名或密码错误");
    }

    /**
     * 修改用户信息
     * 需要修改完成以后的用户作为参数，传参类型为JSON
     * 200-修改成功，400-修改失败
     */
    @PutMapping("updateUser")
    public Result updateUser(HttpSession session, @RequestBody User user){
        user.setUid(((User)session.getAttribute("user")).getUid());
        return iUserService.updateUser(user) > 0 ?
                new Result(200, null, "updateUser OK!!!") :
                new Result(400, null, "updateUser ERROR: 修改失败");
    }
}
