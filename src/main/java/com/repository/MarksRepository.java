package com.repository;

import com.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 54472 on 2018/3/1.
 */
public interface MarksRepository extends JpaRepository<Marks, Serializable> {

    /**
     * 查询物品收藏记录
     */
    Marks findByuserIdAndItemIdAndType(String userId, String itemId, String type);

    /**
     * 书架功能，收藏的书籍，联合两表查询
     */
    @Query(value = "SELECT book.book_img " +
            "FROM book, marks WHERE marks.itemId = book.book_id and userId = ?1 " +
            "GROUP BY book.author", nativeQuery = true)
    List marksBook(String userId);

    @Query(value = "select COUNT(DISTINCT marks.userId) from marks", nativeQuery = true)
    int countUserId();

    @Query(value = "select DISTINCT marks.userId from marks", nativeQuery = true)
    List<String> findUserId();

    @Query(value = "select marks.itemId from marks where userId = ?1 AND type = 'book'", nativeQuery = true)
    List<String> findItemIdByUserId(String usetId);
}
