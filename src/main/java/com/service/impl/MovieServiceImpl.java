package com.service.impl;

import com.entity.Movie;
import com.repository.MovieRepository;
import com.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by 54472 on 2017/12/23.
 */
@Service(value = "movieServiceImpl")
public class MovieServiceImpl implements MovieService {

    private int pageSize = 20;

    @Autowired
    private MovieRepository movieRepository;

    public Page<Movie> getAllMovieInfo(Pageable pageable) {
        Page<Movie> movies = movieRepository.findAll(pageable);
        return movies;
    }

    public Page<Movie> findByKind(String kind, Pageable pageable) {
        Page<Movie> movies = movieRepository.findByKind(kind, pageable);
        return movies;
    }

    public Page<Movie> findAllByRate(Pageable pageable) {
        Page<Movie> movies = movieRepository.findAllByRate(pageable);
        return movies;
    }

    public Page<Movie> findByKindAndOrderByMovieRate(String kind, Pageable pageable) {
        Page<Movie> movies = movieRepository.findByKindAndOrderByRate(kind, pageable);
        return movies;
    }

    public Page<Movie> findMovieByKey(String key, Pageable pageable) {
        Page<Movie> movies = movieRepository.findMovieByKey(key, pageable);
        return movies;
    }
}
