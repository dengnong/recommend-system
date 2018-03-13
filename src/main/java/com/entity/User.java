package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by 54472 on 2017/12/20.
 * 用户实体类
 */
@Entity
@Table(name = "user")
@Cacheable
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "valid")
    private boolean valid = true;

    @Column(name = "taste")
    private String taste;

    public User() {

    }

    public User(String username, String password, LocalDateTime createTime, boolean valid) {
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.valid = valid;
    }

    public User(String username, String password, LocalDateTime createTime, boolean valid, String taste) {
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.valid = valid;
        this.taste = taste;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
