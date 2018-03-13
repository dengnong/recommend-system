package com.repository;

import com.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54472 on 2017/12/21.
 */
public interface BookRepository extends JpaRepository<Book, Serializable> {

    @Query(value = "SELECT * FROM book  WHERE id >= round(((SELECT MAX(id) FROM book ))" +
            " * RAND()*100) LIMIT 5", nativeQuery = true)
    List<Book> findRandBooks();

    @Query(value = "SELECT book_id FROM book  WHERE id >= round(((SELECT MAX(id) FROM book ))" +
            " * RAND()*100) LIMIT 5", nativeQuery = true)
    ArrayList<String> randBooks();

    /**
     * 按分类搜索图书
     * @param kind pageable
     * @return
     */
    Page<Book> findByKind(String kind, Pageable pageable);

    /**
     * 按评价人数降序查找所有书籍
     * @return
     */
    @Query(value = "SELECT * FROM book ORDER BY rate_count+0  DESC /*#pageable*/", nativeQuery = true)
    Page<Book> findAllByRateCount(Pageable pageable);

    /**
     * 按评分降序查询所有书籍
     * @return
     */
    @Query(value = "SELECT * FROM book ORDER BY rate+0  DESC /*#pageable*/", nativeQuery = true)
    Page<Book> findAllByRate(Pageable pageable);

    /**
     * 找出某类书籍并按照评分降序排列
     * @param kind
     * @return
     */
    @Query(value = "SELECT * FROM book WHERE kind = ?1 ORDER BY rate +0 DESC /*#pageable*/", nativeQuery = true)
    Page<Book> findByKindAndOrderByBookRate(String kind, Pageable pageable);

    /**
     * 找出某类书籍并按照评价人数降序排列
     * @param kind
     * @return
     */
    @Query(value = "SELECT * FROM book WHERE kind = ?1 ORDER BY rate_count +0 DESC /*#pageable*/", nativeQuery = true)
    Page<Book> findByKindAndOrderByRateCount(String kind, Pageable pageable);

    /**
     * 书籍名称模糊搜索
     */
    @Query(value = "SELECT * FROM book WHERE name like CONCAT('%',:keyName,'%') GROUP BY author /*#pageable*/", nativeQuery = true)
    Page<Book> findBookByKey(@Param("keyName") String key, Pageable pageable);

    @Query(value = "SELECT * FROM book WHERE book_id = ?1 GROUP BY author", nativeQuery = true)
    Book findBookByBookId(String bookId);
}
