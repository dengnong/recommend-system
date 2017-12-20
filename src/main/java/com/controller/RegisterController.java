package com.controller;

import com.converter.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 54472 on 2017/12/19.
 */
@Controller
public class RegisterController {

    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Object registerUser(@RequestBody Map<String, String> map, Model model) {
        System.out.println(map.get("account"));
        System.out.println(map.get("password"));

        return ResultMsg.success();
    }
}
