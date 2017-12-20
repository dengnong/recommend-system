package com.service;

/**
 * Created by 54472 on 2017/12/20.
 */
public interface UserService {
    Boolean initUser(String username, String password);
    Boolean initUserExist(String username);
}
