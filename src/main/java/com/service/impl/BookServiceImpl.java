package com.service.impl;

import com.entity.Book;
import com.repository.BookRepository;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 54472 on 2017/12/21.
 */
@Service(value = "bookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getRandomBookInfo() {
        List<Book> list = bookRepository.findRandBooks();
        return list;
    }

    /**
     * 该方法适用于展示所有书籍，在pageable传入排序，可以按照条件排序展示数据
     * @return
     */
    public PagedListHolder<Book> getAllBookInfo(int page, int pageSize) {
        List<Book> books = bookRepository.findAll();
        PagedListHolder<Book> list = new PagedListHolder<>(books);
        list.setPage(page);
        list.setPageSize(pageSize);
        return list;
    }

    public PagedListHolder<Book> getBookByKind(String kind, int page, int pageSize) {
        List<Book> books = bookRepository.findByKind(kind);
        PagedListHolder<Book> list = new PagedListHolder<>(books);
        list.setPage(page);
        list.setPageSize(pageSize);
        return list;
    }

    public PagedListHolder<Book> findAllBookByRate(int page, int pageSize) {
        List<Book> list = bookRepository.findAllByRate();
        PagedListHolder<Book> books = new PagedListHolder<>(list);
        books.setPage(page);
        books.setPageSize(pageSize);
        return books;
    }

    public PagedListHolder<Book> findAllBookByRateCount(int page, int pageSize) {
        List<Book> list = bookRepository.findAllByRateCount();
        PagedListHolder<Book> books = new PagedListHolder<>(list);
        books.setPage(page);
        books.setPageSize(pageSize);
        return books;
    }

    public PagedListHolder<Book> findByKindAndOrderByBookRate(String kind, int page, int pageSize) {
        List<Book> list = bookRepository.findByKindAndOrderByBookRate(kind);
        PagedListHolder<Book> books = new PagedListHolder<>(list);
        books.setPage(page);
        books.setPageSize(pageSize);
        return books;
    }

    public PagedListHolder<Book> findByKindAndOrderByRateCount(String kind, int page, int pageSize) {
        List<Book> list = bookRepository.findByKindAndOrderByRateCount(kind);
        PagedListHolder<Book> books = new PagedListHolder<>(list);
        books.setPage(page);
        books.setPageSize(pageSize);
        return books;
    }

}
