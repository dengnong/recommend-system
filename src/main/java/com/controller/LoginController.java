package com.controller;

import com.converter.ResultMsg;
import com.service.CharacterTransformService;
import com.service.GetBookInfoService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @Resource(name = "characterTransformServiceImpl")
    private CharacterTransformService characterTransformService;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "redirect: /homepage";
    }

    @RequestMapping("/login")
    public String login(Model model) throws IOException {
        Map<String, String> map = new HashMap<>();
        //map = getBookInfoService.getJuheBooksJson();
//        model.addAttribute("title", map.get("title"));
////        model.addAttribute("author", map.get("author"));
////        model.addAttribute("publisher", map.get("publisher"));
////        model.addAttribute("summary", map.get("summary"));
//        model.addAttribute("catalog", map.get("catalog"));
//        model.addAttribute("sub2", map.get("sub2").substring(0, 203));
        return "login";
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public Object homeController(@RequestBody Map<String, String> map, Model model){
        String account = map.get("account");
        String password = characterTransformService.encrypt(map.get("password"));
        if(userService.initUser(account, password)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.fault();
        }
    }
}