package com.service.impl;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 54472 on 2017/12/20.
 */
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 验证账号密码
     * @param username
     * @param password
     * @return
     */
    @Override
    public Boolean initUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user != null) {
            return true;
        } else {
            return null;
        }
    }

    /**
     * 验证用户存在
     * @param username
     * @return
     */
    @Override
    public Boolean initUserExist(String username) {
        User user = userRepository.findByUsername(username);
        if(user != null) {
            return true;
        } else {
            return false;
        }
    }
}
