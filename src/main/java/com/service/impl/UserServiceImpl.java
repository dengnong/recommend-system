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

    @Override
    public Boolean initUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        System.out.println(user.getUsername());
        if(user != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean initUserExist(String username) {
        User user = userRepository.findByUsername(username);
        return null;
    }
}
