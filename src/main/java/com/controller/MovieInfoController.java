package com.controller;

import com.service.GetMovieInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 54472 on 2018/1/12.
 */
@Controller
public class MovieInfoController {

    @Resource(name = "getMovieInfoServiceImpl")
    private GetMovieInfoService getMovieInfoService;

    @RequestMapping("/movie")
    public String movieInfo(@RequestParam("id") String movieId, Model model) {
        Map<String, String> map;
        try {
            map = getMovieInfoService.getDoubanMoviesJson(movieId);
        } catch (Exception e) {
            return "404";
        }

        model.addAttribute("movieInfo", map);
        return "movieInfo";
    }
}
