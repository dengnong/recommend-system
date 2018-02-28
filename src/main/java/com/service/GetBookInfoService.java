package com.service;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 54472 on 2017/12/14.
 * 书籍信息网络API接口
 */
public interface GetBookInfoService {

    /**
     * Juhe图书API
     * @return
     */
    Map<String, String> getJuheBooksJson();

    /**
     * Douban图书API
     * @return
     */
    Map<String, String> getDoubanBooksJson(String bookId);

    /**
     * 关键字搜索豆瓣书籍
     */
    ArrayList<Map<String, String>> searchDoubanBook(String key);
}
