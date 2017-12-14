package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 54472 on 2017/12/14.
 */
@Controller
@RequestMapping("/404")
public class NotFoundController {

    @RequestMapping(method = RequestMethod.POST)
    public String post() {
        return "redirect: /404";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "404";
    }

}