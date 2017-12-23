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

    @Column(name = "rate")
    private float movieRate;

    @Column(name = "url")
    private String movieUrl;

    @Column(name = "release_time")
    private String relese_time;

    @Column(name = "actors")
    private String actors;

    @Column(name = "movie_id")
    private String movieId;

    public Movie() {
    }

    public Movie(String movieName, float movieRate, String movieUrl,
                 String relese_time, String actors, String movieId) {
        this.movieName = movieName;
        this.movieRate = movieRate;
        this.movieUrl = movieUrl;
        this.relese_time = relese_time;
        this.actors = actors;
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public float getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(float movieRate) {
        this.movieRate = movieRate;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getRelese_time() {
        return relese_time;
    }

    public void setRelese_time(String relese_time) {
        this.relese_time = relese_time;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
