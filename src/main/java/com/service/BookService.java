package com.service;

import com.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by 54472 on 2017/12/21.
 */
public interface BookService  {

    /**
     * 首页随机抽取5本书
     * @return
     */
    List<Book> getRandomBookInfo();

    /**
     * 全部书籍
     * @return
     */
    Page<Book> getAllBookInfo(Pageable pageable);

    /**
     * 小说
     * @Param kind 小说
     * @return
     */
    Page<Book> getBookByKind(String kind);

}
