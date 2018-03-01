package com.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by 54472 on 2018/3/1.
 */
@Entity
@Table(name = "marks")
@Cacheable
public class Marks {

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

    public Marks() {

    }

    public Marks(String userId, String itemId, String type, LocalDateTime createTime) {
        this.userId = userId;
        this.itemId = itemId;
        this.type = type;
        this.createTime = createTime;
    }

    public Marks(String userId, String itemId, String type) {
        this.userId = userId;
        this.itemId = itemId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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
}
