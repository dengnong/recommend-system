package com.controller;

import com.service.GetBookInfoService;
import com.service.MarksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 书籍详细信息
 * Created by 54472 on 2018/1/5.
 */
@Controller
@SessionAttributes("userInfo")
public class BookInfoController {

    @Resource(name = "getBookInfoServiceImpl")
    private GetBookInfoService getBookInfoService;

    @Resource(name = "marksServiceImpl")
    private MarksService marksService;

    @RequestMapping("/book")
    public String bookInfo(@RequestParam("id") String bookId, Model model, HttpSession httpSession) {
        Map<String, String> map;
        try {
            map = getBookInfoService.getDoubanBooksJson(bookId);
        } catch (Exception e) {
            return "404";
        }

        if(httpSession.getAttribute("userInfo") != null) {
            String userId = (String) httpSession.getAttribute("userInfo");
            model.addAttribute("marks", marksService.markInit(userId, bookId, "book"));
            System.out.println(userId + " " + marksService.markInit(userId, bookId, "book"));
        } else {
            model.addAttribute("marks", false);
        }
        model.addAttribute("bookInfo", map);
        model.addAttribute("bookId", bookId);
        return "bookInfo";
    }
}
