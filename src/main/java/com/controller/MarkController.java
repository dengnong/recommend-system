package com.controller;

import com.service.MarksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 54472 on 2018/3/1.
 */
@Controller
public class MarkController {

    @Resource(name = "marksServiceImpl")
    private MarksService marksService;

    @RequestMapping(value = "markItem", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public void mark(@RequestBody Map<String, String> map) {
        String userId = map.get("userId");
        String itemId = map.get("itemId");
        String type = map.get("type");
        marksService.markItem(userId, itemId, type);
    }

    @RequestMapping(value = "markCancel", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public void markcancel(@RequestBody Map<String, String> map) {
        String userId = map.get("userId");
        String itemId = map.get("itemId");
        String type = map.get("type");
        marksService.markCancel(userId, itemId, type);
    }
}
