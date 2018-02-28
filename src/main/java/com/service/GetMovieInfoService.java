package com.service;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 54472 on 2017/12/21.
 * 电影信息API
 */
public interface GetMovieInfoService {
    ArrayList<Map<String, Object>> getTimeMoviesJson();

    Map<String, String> getDoubanMoviesJson(String movieId);

    ArrayList<Map<String, String>> searchDoubanMovie(String key);
}
