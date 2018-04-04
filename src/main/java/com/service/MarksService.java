package com.service;

import com.entity.Book;
import com.entity.Movie;

import java.util.List;

/**
 * Created by 54472 on 2018/3/1.
 */
public interface MarksService {

    /**
     * 添加收藏记录
     */
    void markItem(String userId, String itemId, String type);

    /**
     * 查询收藏记录
     */
    boolean markInit(String userId, String itemId, String type);

    /**
     * 取消收藏
     */
    void markCancel(String userId, String itemId, String type);

    /**
     * 统计搜藏排序
     */
    List<Book> marksBook(String type);

    List<Movie> marksMovie(String type);
}
