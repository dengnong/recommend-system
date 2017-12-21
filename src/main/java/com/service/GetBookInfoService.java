package com.service;

import java.util.Map;

/**
 * Created by 54472 on 2017/12/14.
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
    Map<String, String> getDoubanBooksJson();
}
