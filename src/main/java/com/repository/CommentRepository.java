package com.repository;

import com.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 54472 on 2018/3/7.
 */
public interface CommentRepository extends JpaRepository<Comment, Serializable> {

    /**
     * 查询条目相关的评论，只需要条目id和类型
     */
    List<Comment> findByItemIdAndType(String itemId, String type);
}
