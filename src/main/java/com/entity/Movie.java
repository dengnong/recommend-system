package com.entity;

import javax.persistence.*;

/**
 * Created by 54472 on 2017/12/23.
 */
@Entity
@Table(name = "movie")
@Cacheable
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "name")
    private String movieName;

    @Column(name = "director")
    private String director;

    @Column(name = "rate")
    private String rate;

    @Column(name = "movie_id")
    private String movieId;

    @Column(name = "actors")
    private String actors;

    @Column(name = "url")
    private String url;

    @Column(name = "image")
    private String image;

    @Column(name = "kind")
    private String kind;

    public Movie() {
    }

    public Movie(String movieName, String director, String rate, String movieId,
                 String actors, String url, String image, String kind) {
        this.movieName = movieName;
        this.director = director;
        this.rate = rate;
        this.movieId = movieId;
        this.actors = actors;
        this.url = url;
        this.image = image;
        this.kind = kind;
    }

    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
