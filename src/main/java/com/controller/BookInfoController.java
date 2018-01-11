package com.controller;

import com.service.GetBookInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 书籍详细信息
 * Created by 54472 on 2018/1/5.
 */
@Controller
public class BookInfoController {

    @Resource(name = "getBookInfoServiceImpl")
    private GetBookInfoService getBookInfoService;

    @RequestMapping("/book")
    public String bookInfo(@RequestParam("id") String bookId, Model model) {
        Map<String, String> map;
        try {
            map = getBookInfoService.getDoubanBooksJson(bookId);
        } catch (Exception e) {
            return "error";
        }

        model.addAttribute("bookInfo", map);
        return "bookInfo";
    }
}
