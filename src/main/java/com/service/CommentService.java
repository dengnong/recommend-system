package com.service;

import com.entity.Comment;

import java.util.List;

/**
 * Created by 54472 on 2018/3/7.
 */
public interface CommentService {

    /**
     * 查询条目相关的评论，只需要条目id和类型
     */
    List<Comment> findComment(String itemId, String type);

    /**
     * 保存评论和评分
     */
    void saveComment(String userId, String itemId, String type, String content, String score);
}
