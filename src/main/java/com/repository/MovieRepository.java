package com.repository;

import com.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * Created by 54472 on 2017/12/23.
 */
public interface MovieRepository extends JpaRepository<Movie, Serializable> {

    /**
     * 按分类搜索电影
     * @param kind
     * @return
     */
    Page<Movie> findByKind(String kind, Pageable pageable);

    /**
     * 按评分排列全部电影
     * @return
     */
    @Query(value = "SELECT * FROM movie ORDER BY rate+0  DESC /*#pageable*/", nativeQuery = true)
    Page<Movie> findAllByRate(Pageable pageable);

    /**
     *搜索某类电影并按评分降序排列
     * @return
     */
    @Query(value = "SELECT * FROM movie WHERE kind = ?1 ORDER BY rate +0 DESC /*#pageable*/", nativeQuery = true)
    Page<Movie> findByKindAndOrderByRate(String kind, Pageable pageable);




}
