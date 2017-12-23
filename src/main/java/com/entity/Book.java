package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 54472 on 2017/12/21.
 * 本地书籍实体类
 */
@Entity
@Table(name = "book")
@Cacheable
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "name")
    private String bookName;

    @Column(name = "rate")
    private float bookRate;

    @Column(name = "price")
    private String bookPrice;

    @Column(name = "publisher")
    private String bookPublisher;

    @Column(name = "url")
    private String bookUrl;

    @Column(name = "book_id")
    private String bookId;

    public Book() {
    }

    public Book(String bookName, float bookRate,
                String bookPrice, String bookPublisher, String bookUrl, String bookId) {
        this.bookName = bookName;
        this.bookRate = bookRate;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
        this.bookUrl = bookUrl;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getBookRate() {
        return bookRate;
    }

    public void setBookRate(float bookRate) {
        this.bookRate = bookRate;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
