package com.service;

/**
 * Created by 54472 on 2017/12/20.
 */
public interface UserService {
    /**
     * 验证账号密码
     * @param username
     * @param password
     * @return
     */
    Boolean initUser(String username, String password);

    /**
     * 验证用户存在
     * @param username
     * @return
     */
    Boolean initUserExist(String username);
}
