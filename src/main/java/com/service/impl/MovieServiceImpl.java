package com.service.impl;

import com.repository.MovieRepository;
import com.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 54472 on 2017/12/23.
 */
@Service(value = "movieServiceImpl")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
}
