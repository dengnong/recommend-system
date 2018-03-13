package com.service.impl;

import com.entity.Book;
import com.repository.BookRepository;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Page<Book> getAllBookInfo(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        return books;
    }

    public Page<Book> getBookByKind(String kind, Pageable pageable) {
        Page<Book> books = bookRepository.findByKind(kind, pageable);
        return books;
    }

    public Page<Book> findAllBookByRate(Pageable pageable) {
        Page<Book> books = bookRepository.findAllByRate(pageable);
        return books;
    }

    public Page<Book> findAllBookByRateCount(Pageable pageable) {
        Page<Book> books = bookRepository.findAllByRateCount(pageable);
        return books;
    }

    public Page<Book> findByKindAndOrderByBookRate(String kind, Pageable pageable) {
        Page<Book> books = bookRepository.findByKindAndOrderByBookRate(kind, pageable);
        return books;
    }

    public Page<Book> findByKindAndOrderByRateCount(String kind, Pageable pageable) {
        Page<Book> books = bookRepository.findByKindAndOrderByRateCount(kind, pageable);
        return books;
    }

    public Page<Book> findBookByKey(String key, Pageable pageable) {
        Page<Book> books = bookRepository.findBookByKey(key, pageable);
        return books;
    }

    public ArrayList<String> bookRandom() {
        ArrayList<String> books = bookRepository.randBooks();
        return books;
    }

    public List<Book> findBookById(List<String> list) {
        ArrayList<Book> arrayList = new ArrayList<>();
        for(int i = 0; i < 5; i ++) {
            arrayList.add(bookRepository.findBookByBookId(list.get(i)));
        }
        return arrayList;
    }
}
