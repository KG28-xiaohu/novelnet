package com.novelnet.demo.service;

import com.novelnet.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;

public interface IUserService {
    //登录
    User login(String account, String password);
    //注册
    int enroll(User user);
    //找回密码
    String getPassword(String account, String email);
    //修改密码
    int updatePassword(int uid, String password, String newPassword);
    //获取登录用户的个人信息
    User getUserNoPassword(int uid);
    //修改用户信息
    int updateUser(User user);
}
