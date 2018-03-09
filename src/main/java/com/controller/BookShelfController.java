package com.controller;

import com.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 54472 on 2018/3/9.
 */
@Controller
public class BookShelfController {

    @Autowired
    private MarksRepository marksRepository;

    @RequestMapping("bookShelf")
    public String bookShelf(Model model, HttpSession httpSession) {
        if(httpSession.getAttribute("userInfo") != null) {
            model.addAttribute("books", marksRepository.marksBook(httpSession.getAttribute("userInfo").toString()));
            return "bookShelf";
        }
        return "login";
    }
}
