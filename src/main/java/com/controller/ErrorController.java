package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 54472 on 2017/12/14.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping(method = RequestMethod.POST)
    public String post() {
        return "redirect: /error";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "error";
    }
}