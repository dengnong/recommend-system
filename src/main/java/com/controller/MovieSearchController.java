package com.controller;

import com.entity.Movie;
import com.service.GetMovieInfoService;
import com.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 54472 on 2018/2/28.
 */
@Controller
public class MovieSearchController {

    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    @Resource(name = "getMovieInfoServiceImpl")
    private GetMovieInfoService getMovieInfoService;

    @RequestMapping(value = "movieSearch")
    public String movieSearch(@RequestParam("key") String key, Model model) {
        Pageable pageable = new PageRequest(0, 10);
        Page<Movie> movies = null;
        ArrayList<Map<String, String>> list = new ArrayList<>();
        movies = movieService.findMovieByKey(key, pageable);
        list = getMovieInfoService.searchDoubanMovie(key);
        model.addAttribute("movieLists", movies);
        model.addAttribute("doubanLists", list);
        return "movieSearchResult";
    }
}
