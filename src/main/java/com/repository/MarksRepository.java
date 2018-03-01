package com.repository;

import com.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by 54472 on 2018/3/1.
 */
public interface MarksRepository extends JpaRepository<Marks, Serializable> {

    /**
     * 查询物品收藏记录
     */
    Marks findByuserIdAndItemIdAndType(String userId, String itemId, String type);
}
