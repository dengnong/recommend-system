package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 54472 on 2017/12/14.
 */
@Controller
public class HomeController {

    @RequestMapping("/homepage")
    public String homeController(){
        return "home";
    }
}
