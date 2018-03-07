package com.controller;

import com.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 54472 on 2018/3/7.
 */
@Controller
public class CommentController {

    @Resource(name = "commentServiceImpl")
    private CommentService commentService;

    @RequestMapping(value = "saveComment", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public void saveComment(@RequestBody Map<String, String> map) {
        String userId = map.get("userId");
        String itemId = map.get("itemId");
        String type = map.get("type");
        String content = map.get("content");
        String score = map.get("score");
        commentService.saveComment(userId, itemId, type, content, score);
    }
}
