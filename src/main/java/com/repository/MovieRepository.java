package com.repository;

import com.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by 54472 on 2017/12/23.
 */
public interface MovieRepository extends JpaRepository<Movie, Serializable> {
}
