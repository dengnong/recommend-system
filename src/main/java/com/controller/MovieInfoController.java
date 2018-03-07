package com.controller;

import com.service.CommentService;
import com.service.GetMovieInfoService;
import com.service.MarksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    @Resource(name = "commentServiceImpl")
    private CommentService commentService;

    @RequestMapping("/movie")
    public String movieInfo(@RequestParam("id") String movieId, Model model, HttpSession httpSession) {
        Map<String, String> map;
        try {
            map = getMovieInfoService.getDoubanMoviesJson(movieId);
        } catch (Exception e) {
            return "404";
        }

        if(httpSession.getAttribute("userInfo") != null) {
            String userId = (String) httpSession.getAttribute("userInfo");
            model.addAttribute("marks", marksService.markInit(userId, movieId, "movie"));
        } else {
            model.addAttribute("marks", false);
        }

        model.addAttribute("movieId", movieId);
        model.addAttribute("movieInfo", map);
        model.addAttribute("comment", commentService.findComment(movieId, "movie"));
        return "movieInfo";
    }
}
