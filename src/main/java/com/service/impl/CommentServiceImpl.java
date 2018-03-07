package com.service.impl;

import com.entity.Comment;
import com.repository.CommentRepository;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by 54472 on 2018/3/7.
 */
@Service(value = "commentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 查询条目相关的评论，只需要条目id和类型
     */
    public List<Comment> findComment(String itemId, String type) {
        List<Comment> list = commentRepository.findByItemIdAndType(itemId, type);
        return list;
    }

    public void saveComment(String userId, String itemId, String type, String content, String score) {
        Comment comment = new Comment(userId, itemId, type, LocalDateTime.now(), content, score);
        commentRepository.save(comment);
    }
}
