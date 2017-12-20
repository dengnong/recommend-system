package com.repository;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by 54472 on 2017/12/20.
 */
public interface UserRepository extends JpaRepository<User, Serializable> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
