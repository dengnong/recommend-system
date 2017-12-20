package com.controller;

import com.converter.gson.GsonLocalDateTimeConverter;
import com.entity.UserDemo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.UserDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserDemoController {

    @Autowired
    @Qualifier(value = "userDemoService")
    private UserDemoService userDemoService;

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeConverter())
            .create();

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(@RequestParam(value = "name") String name,
                            @RequestParam(value = "createTime")
                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime now) {
        userDemoService.save(new UserDemo(name, now));
        return null;
    }

    @RequestMapping(value = "/add/and/show", method = RequestMethod.GET)
    public String addRedirect(@RequestParam(value = "name") String name,
                              @RequestParam(value = "createTime")
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime now) {
        UserDemo userDemo = userDemoService.save(new UserDemo(name, now));
        return "redirect:/userDemo/" + userDemo.getId() + "/show";
    }

    @RequestMapping(value = "/{id:\\d+}/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable(value = "id") int id) {
        userDemoService.delete(id);
        return "{\"status\":200}";
    }

    @RequestMapping(value = "/{id:\\d+}/show", method = RequestMethod.GET)
    @ResponseBody
    public String show(@PathVariable(value = "id") int id) {
        return gson.toJson(userDemoService.findOne(id));
    }

    @RequestMapping(value = "/page/{pageOffset:\\d+}/{pageSize:\\d+}", method = RequestMethod.GET)
    public String page(@PathVariable(value = "pageOffset") int pageOffset,
                       @PathVariable(value = "pageSize") int pageSize,
                       Model model) {
        Pageable pageable = new PageRequest(pageOffset, pageSize);
        Page<UserDemo> userPage = userDemoService.find(pageable);
        model.addAttribute("page", userPage);
        return "page";
    }

}
