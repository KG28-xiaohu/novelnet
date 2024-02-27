package com.novelnet.demo.service.impl;

import com.novelnet.demo.mapper.UserMapper;
import com.novelnet.demo.pojo.User;
import com.novelnet.demo.service.IUserService;
import com.novelnet.demo.util.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public String login(String account, String password) {
        User user = userMapper.login(account, password);
        if (user != null){
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            return TokenUtil.makeToken(map);
        }
        return null;
    }

    @Override
    public int enroll(User user) {
        int i1 = userMapper.isHaveAccount(user.getAccount());
        if (i1 > 0){
            return -1;
        }
        int i2 = userMapper.enroll(user);
        if (i2 == 0){
            return 0;
        }
        return 1;
    }

    @Override
    public String getPassword(String account, String email) {
        User user = userMapper.getUserByAccountAndEmail(account, email);
        if(user == null){
            return null;
        }
        return user.getPassword();
    }
}
