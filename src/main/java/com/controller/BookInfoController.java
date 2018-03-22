package com.controller;

import com.entity.Book;
import com.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
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

    @Resource(name = "userCFServiceImpl")
    private UserCFService userCFService;

    @Resource(name = "bookServiceImpl")
    private BookService bookService;

    @Resource(name = "commentServiceImpl")
    private CommentService commentService;

    @RequestMapping("/book")
    public String bookInfo(@RequestParam("id") String bookId, Model model, HttpSession httpSession) {
        Map<String, String> map;
        try {
            map = getBookInfoService.getDoubanBooksJson(bookId);
        } catch (Exception e) {
            return "404";
        }

        List<String> list = null;
        List<Book> list2 = null;
        if(httpSession.getAttribute("userInfo") != null) {
            String userId = (String) httpSession.getAttribute("userInfo");
            model.addAttribute("marks", marksService.markInit(userId, bookId, "book"));
            list = userCFService.userCf(userId);
            list2 = bookService.findBookById(list);
//            System.out.println(userId + " " + marksService.markInit(userId, bookId, "book"));
        } else {
            model.addAttribute("marks", false);
            list = userCFService.userCf();
            list2 = bookService.findBookById(list);
        }
        model.addAttribute("recommendBook", list2);
        model.addAttribute("bookInfo", map);
        model.addAttribute("bookId", bookId);
        model.addAttribute("comment", commentService.findComment(bookId, "book"));
        return "bookInfo";
    }
}
