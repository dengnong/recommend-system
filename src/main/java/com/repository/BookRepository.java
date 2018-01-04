package com.repository;

import com.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 54472 on 2017/12/21.
 */
public interface BookRepository extends JpaRepository<Book, Serializable> {

    @Query(value = "SELECT * FROM book  WHERE id >= round(((SELECT MAX(id) FROM book ))" +
            " * RAND()*100) LIMIT 5", nativeQuery = true)
    List<Book> findRandBooks();

    /**
     * 按分类搜索图书
     * @param kind pageable
     * @return
     */
    List<Book> findByKind(String kind);

    /**
     * 按评价人数降序查找所有书籍
     * @return
     */
    @Query(value = "SELECT * FROM book ORDER BY rate_count+0  DESC", nativeQuery = true)
    List<Book> findAllByRateCount();

    /**
     * 按评分降序查询所有书籍
     * @return
     */
    @Query(value = "SELECT * FROM book ORDER BY rate+0  DESC", nativeQuery = true)
    List<Book> findAllByRate();

    /**
     * 找出某类书籍并按照评分降序排列
     * @param kind
     * @return
     */
    @Query(value = "SELECT * FROM book WHERE kind = ?1 ORDER BY rate +0 DESC", nativeQuery = true)
    List<Book> findByKindAndOrderByBookRate(String kind);

    /**
     * 找出某类书籍并按照评价人数降序排列
     * @param kind
     * @return
     */
    @Query(value = "SELECT * FROM book WHERE kind = ?1 ORDER BY rate_count +0 DESC", nativeQuery = true)
    List<Book> findByKindAndOrderByRateCount(String kind);
}
