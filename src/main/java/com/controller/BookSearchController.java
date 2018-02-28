package com.controller;

import com.entity.Book;
import com.service.BookService;
import com.service.GetBookInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 54472 on 2018/2/26.
 */
@Controller
public class BookSearchController {

    @Resource(name = "bookServiceImpl")
    private BookService bookService;

    @Resource(name = "getBookInfoServiceImpl")
    private GetBookInfoService getBookInfoService;

    @RequestMapping(value = "bookSearch")
    public String bookSearch(@RequestParam("key") String key, Model model) {
        Pageable pageable = new PageRequest(0, 10);
        Page<Book> books = null;
        ArrayList<Map<String, String>> list = new ArrayList<>();
        books = bookService.findBookByKey(key, pageable);
        list = getBookInfoService.searchDoubanBook(key);
        model.addAttribute("bookLists", books);
        model.addAttribute("doubanLists", list);
        return "bookSearchResult";
    }
}
