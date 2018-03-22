package com.controller;

import com.entity.Movie;
import com.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by 54472 on 2018/1/12.
 */
@Controller
public class MovieInfoController {

    @Resource(name = "getMovieInfoServiceImpl")
    private GetMovieInfoService getMovieInfoService;

    @Resource(name = "marksServiceImpl")
    private MarksService marksService;

    @Resource(name = "userCFServiceImpl")
    private UserCFService userCFService;

    @Resource(name = "commentServiceImpl")
    private CommentService commentService;

    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    @RequestMapping("/movie")
    public String movieInfo(@RequestParam("id") String movieId, Model model, HttpSession httpSession) {
        Map<String, String> map;
        try {
            map = getMovieInfoService.getDoubanMoviesJson(movieId);
        } catch (Exception e) {
            return "404";
        }

        List<String> list = null;
        List<Movie> list2 = null;
        if(httpSession.getAttribute("userInfo") != null) {
            String userId = (String) httpSession.getAttribute("userInfo");
            model.addAttribute("marks", marksService.markInit(userId, movieId, "movie"));
            list = userCFService.userCf(userId, "movie");
            list.addAll(movieService.movieRandom());
            list2 = movieService.findMovieById(list);
        } else {
            model.addAttribute("marks", false);
            list = userCFService.userCF2();
            list.addAll(movieService.movieRandom());
            list2 = movieService.findMovieById(list);
        }

        model.addAttribute("recommendMovie", list2);
        model.addAttribute("movieId", movieId);
        model.addAttribute("movieInfo", map);
        model.addAttribute("comment", commentService.findComment(movieId, "movie"));
        return "movieInfo";
    }
}
