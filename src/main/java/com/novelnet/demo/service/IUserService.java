package com.novelnet.demo.service;

import com.novelnet.demo.pojo.User;

import javax.servlet.http.HttpSession;

public interface IUserService {
    //登录
    String login(String account, String password, HttpSession session);
    //注册
    int enroll(User user);
    //找回密码
    String getPassword(String account, String email);
}
