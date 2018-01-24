package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 54472 on 2018/1/24.
 */
@Controller
public class FoodListController {

    @RequestMapping("/foods")
    public String foodsList() {

        return "foodList";
    }
}
