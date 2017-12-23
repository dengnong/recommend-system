package com.controller;

import com.service.GetMovieInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by 54472 on 2017/12/14.
 */
@Controller
public class HomeController {

    @Resource(name = "getMovieInfoServiceImpl")
    private GetMovieInfoService getMovieInfoService;

    @RequestMapping("/homepage")
    public String homeController(Model model){
        System.out.println("redirect page: homepage");
//        if(GetMoviesTask.moviesShowingInfo != null) {
//            model.addAttribute("moviesShowing", GetMoviesTask.moviesShowingInfo);
//        }

        model.addAttribute("moviesShowing", getMovieInfoService.getTimeMoviesJson());
        return "home";
    }
}
