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
     * @param kind
     * @return
     */
    List<Book> findByKind(String kind);

//    Page<Book> findByKindAndOrderByBookRate(String kind);
//
//    Page<Book> findAllByKindAndOrderByRateCount(String Kind);
    /**
     * SELECT * FROM book  WHERE id >= " +
     "((SELECT MAX(id) FROM book )-(SELECT MIN(id) FROM book )) " +
     "* RAND() + (SELECT MIN(id) FROM book )  LIMIT 5
     */
}
