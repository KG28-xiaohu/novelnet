package com.novelnet.demo.service.impl;
import com.novelnet.demo.mapper.UserMapper;
import com.novelnet.demo.pojo.User;
import com.novelnet.demo.service.IUserService;
import com.novelnet.demo.util.MD5Util;
import com.novelnet.demo.util.TokenUtil;
import jdk.nashorn.internal.objects.NativeJSON;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String account, String password) {
        String newPassword = MD5Util.stringToMD5(password);
        return userMapper.login(account, newPassword);
    }

    @Override
    public int enroll(User user) {
        User user1 = userMapper.isHaveAccount(user.getAccount());
        if (user1 != null){
            return -1;
        }
        String password = user.getPassword();
        String newPassword = MD5Util.stringToMD5(password);
        user.setPassword(newPassword);
        int i1 = userMapper.enroll(user);
        if (i1 == 0){
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

    @Override
    public int updatePassword(int uid, String password, String newPassword) {
        User user = userMapper.getUserById(uid);
        if (!MD5Util.stringToMD5(password).equals(user.getPassword())) {
            return -1;
        }
        return userMapper.updatePassword(uid, newPassword);
    }

    @Override
    public User getUserNoPassword(int uid) {
        return userMapper.getUserNoPassword(uid);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
