package com.novelnet.demo.mapper;

import com.novelnet.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //登录
    User login(@Param("account") String account, @Param("password") String password);
    //验证账号存在
    int isHaveAccount(@Param("account") String account);
    //注册
    int enroll(@Param("user") User user);
    //找回密码
    User getUserByAccountAndEmail(@Param("account") String account, @Param("email") String email);
}
