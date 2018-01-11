package com.controller;

import com.entity.Movie;
import com.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by 54472 on 2018/1/9.
 */
@Controller
public class MoviesListController {

    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    @RequestMapping("/movies")
    public String moviesList(@RequestParam("kind") String kind,
                             @RequestParam("page") int pageOffSet,
                             @RequestParam("sort") String sortParam,
                             Model model) {
        pageOffSet = pageOffSet - 1;
        int pageSize = 20;
        Pageable pageable = new PageRequest(pageOffSet, pageSize);
        Page<Movie> movies = null;

        if(sortParam.equals("rate")) {
            if(kind.equals("全部")) {
                movies = movieService.findAllByRate(pageable);
            } else {
                movies = movieService.findByKindAndOrderByMovieRate(kind, pageable);
            }
        } else if(!kind.equals("全部")) {
            movies = movieService.findByKind(kind, pageable);
        } else {
            movies = movieService.getAllMovieInfo(pageable);
        }

        model.addAttribute("moviesLists", movies);
        model.addAttribute("kind", kind);
        model.addAttribute("sort", sortParam);
        return "moviesList";
    }
}
