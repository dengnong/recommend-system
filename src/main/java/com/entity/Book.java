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
    private String bookRate;

    @Column(name = "rate_count")
    private String rateCount;

    @Column(name = "author")
    private String bookAuthor;

    @Column(name = "book_url")
    private String bookUrl;

    @Column(name = "book_img")
    private String bookImg;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "kind")
    private String kind;

    @Column(name = "introduction")
    private String introduction;

    public Book() {
    }

    public Book(String bookName, String bookRate, String rateCount, String bookAuthor,
                String bookUrl, String bookImg, String bookId,
                String kind, String introduction) {
        this.bookName = bookName;
        this.bookRate = bookRate;
        this.rateCount = rateCount;
        this.bookAuthor = bookAuthor;
        this.bookUrl = bookUrl;
        this.bookImg = bookImg;
        this.bookId = bookId;
        this.kind = kind;
        this.introduction = introduction;
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

    public String getBookRate() {
        return bookRate;
    }

    public void setBookRate(String bookRate) {
        this.bookRate = bookRate;
    }

    public String getRateCount() {
        return rateCount;
    }

    public void setRateCount(String rateCount) {
        this.rateCount = rateCount;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
