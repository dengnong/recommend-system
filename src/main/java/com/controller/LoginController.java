package com.controller;

import com.service.GetBookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 54472 on 2017/11/12.
 */
@Controller
public class LoginController {

    @Autowired
    @Qualifier(value = "getBookInfoServiceImpl")
    private GetBookInfoService getBookInfoService;

    @RequestMapping("/")
    public String home() {
        return "redirect: /home";
    }

    @RequestMapping("/index")
    public String login(Model model) throws IOException {
        Map<String, String> map = new HashMap<>();
        //map = getBookInfoService.getJuheBooksJson();
//        model.addAttribute("title", map.get("title"));
////        model.addAttribute("author", map.get("author"));
////        model.addAttribute("publisher", map.get("publisher"));
////        model.addAttribute("summary", map.get("summary"));
//        model.addAttribute("catalog", map.get("catalog"));
//        model.addAttribute("sub2", map.get("sub2").substring(0, 203));
        return "/index";
    }
}