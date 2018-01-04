package com.service;

import com.entity.Book;
import org.springframework.beans.support.PagedListHolder;

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
    PagedListHolder<Book> getAllBookInfo(int page, int pageSize);

    /**
     * 分类查找图书
     * @return
     */
    PagedListHolder<Book> getBookByKind(String kind, int page, int pageSize);

    /**
     * 按评分排序所有书籍
     * @return
     */
    PagedListHolder<Book> findAllBookByRate(int page, int pageSize);

    /**
     * 按评价人数排序所有书籍
     * @return
     */
    PagedListHolder<Book> findAllBookByRateCount(int page, int pageSize);

    /**
     * 找出某类书籍并按照评分降序排列
     * @param kind
     * @return
     */
    PagedListHolder<Book> findByKindAndOrderByBookRate(String kind, int page, int pageSize);

    /**
     * 找出某类书籍并按照评价人数降序排列
     * @param kind
     * @return
     */
    PagedListHolder<Book> findByKindAndOrderByRateCount(String kind, int page, int pageSize);
}
