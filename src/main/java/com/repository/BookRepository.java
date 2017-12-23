package com.repository;

import com.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by 54472 on 2017/12/21.
 */
public interface BookRepository extends JpaRepository<Book, Serializable> {
}
