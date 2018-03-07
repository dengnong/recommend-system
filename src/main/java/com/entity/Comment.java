package com.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by 54472 on 2018/3/7.
 */
@Entity
@Table(name = "comment")
@Cacheable
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "itemId")
    private String itemId;

    @Column(name = "type")
    private String type;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "content")
    private String content;

    @Column(name = "score")
    private String score;

    public Comment() {

    }

    public Comment(String userId, String itemId, String type, LocalDateTime createTime, String content, String score) {
        this.userId = userId;
        this.itemId = itemId;
        this.type = type;
        this.createTime = createTime;
        this.content = content;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
