package com.controller;

import com.entity.Book;
import com.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * 书籍列表
 * Created by 54472 on 2017/12/28.
 */
@Controller
public class BooksListController {

    @Resource(name = "bookServiceImpl")
    private BookService bookService;

    @RequestMapping(value = "/bookslist/{kind}/{pageOffSet}", method = RequestMethod.GET)
    public String booksList(@PathVariable String kind,
                            @PathVariable int pageOffSet, Model model) {


        //传入页码和每页显示条数
        Pageable pageable = new PageRequest(pageOffSet - 1, 15);
        Page<Book> books = bookService.getAllBookInfo(pageable);
        System.out.println(books.getTotalPages() +"****************************current page:" + books.getNumber());

        model.addAttribute("bookLists", books);
        model.addAttribute("kind", kind);

        return "booksList";
    }
}
