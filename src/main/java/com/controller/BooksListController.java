package com.controller;

import com.entity.Book;
import com.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 书籍列表
 * Created by 54472 on 2017/12/28.
 */
@Controller
public class BooksListController {

    @Resource(name = "bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/books")
    public String booksList(@RequestParam("kind") String kind,
                            @RequestParam("page") int pageOffSet,
                            @RequestParam("sort") String sortParam,
                            Model model) {
        pageOffSet = pageOffSet - 1;
        int pageSize = 15;
        Pageable pageable = new PageRequest(pageOffSet, pageSize);
        Page<Book> books = null;
        //传入页码和每页显示条数
        if(sortParam.equals("rate")) {
            if(kind.equals("全部")) {
                books = bookService.findAllBookByRate(pageable);
            } else {
                books = bookService.findByKindAndOrderByBookRate(kind, pageable);
            }
        } else if(sortParam.equals("count")) {
            if(kind.equals("全部")) {
                books = bookService.findAllBookByRateCount(pageable);
            } else {
                books = bookService.findByKindAndOrderByRateCount(kind, pageable);
            }
        } else if(!kind.equals("全部")){
            books = bookService.getBookByKind(kind, pageable);
        } else {
            books = bookService.getAllBookInfo(pageable);
        }

        model.addAttribute("bookLists", books);
        model.addAttribute("kind", kind);
        model.addAttribute("sort", sortParam);
        return "booksList";
    }
}
