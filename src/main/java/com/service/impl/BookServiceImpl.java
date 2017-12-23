package com.service.impl;

import com.repository.BookRepository;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 54472 on 2017/12/21.
 */
@Service(value = "bookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
}
