package com.service;

import java.util.Map;

/**
 * Created by 54472 on 2017/12/14.
 */
public interface GetBookInfoService {

    Map<String, String> getJuheBooksJson();

    Map<String, String> getDoubanBooksJson();
}
