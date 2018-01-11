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
     * 分类查找图书
     * @return
     */
    Page<Book> getBookByKind(String kind, Pageable pageable);

    /**
     * 按评分排序所有书籍
     * @return
     */
    Page<Book> findAllBookByRate(Pageable pageable);

    /**
     * 按评价人数排序所有书籍
     * @return
     */
    Page<Book> findAllBookByRateCount(Pageable pageable);

    /**
     * 找出某类书籍并按照评分降序排列
     * @param kind
     * @return
     */
    Page<Book> findByKindAndOrderByBookRate(String kind, Pageable pageable);

    /**
     * 找出某类书籍并按照评价人数降序排列
     * @param kind
     * @return
     */
    Page<Book> findByKindAndOrderByRateCount(String kind, Pageable pageable);
}
