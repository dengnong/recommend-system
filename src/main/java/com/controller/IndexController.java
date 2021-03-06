package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.application.DoubanBookAPI.getDoubanBooksJson;

/**
 * Created by 54472 on 2017/11/12.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String home() {
        return "redirect: /index";
    }

    @RequestMapping("/index")
    public String index(Model model) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map = getDoubanBooksJson();
        model.addAttribute("title", map.get("title"));
        model.addAttribute("author", map.get("author"));
        model.addAttribute("publisher", map.get("publisher"));
        model.addAttribute("summary", map.get("summary"));
        return "/index";
    }
}