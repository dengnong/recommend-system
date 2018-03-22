package com.service;

import com.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54472 on 2017/12/23.
 */
public interface MovieService {

    /**
     *查找全部电影
     * @return
     */
    Page<Movie> getAllMovieInfo(Pageable pageable);

    /**
     *按分类展示电影
     * @return
     */
    Page<Movie> findByKind(String kind, Pageable pageable);

    /**
     * 按评分排序全部电影
     * @return
     */
    Page<Movie> findAllByRate(Pageable pageable);

    /**
     * 按类别展示电影并按评分排序
     * @return
     */
    Page<Movie> findByKindAndOrderByMovieRate(String kind, Pageable pageable);

    /**
     * 电影名称模糊搜索（数据库）
     */
    Page<Movie> findMovieByKey(String key, Pageable pageable);

    List<Movie> findMovieById(List<String> list);

    ArrayList<String> movieRandom();
}
