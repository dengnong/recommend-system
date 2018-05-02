package com.controller;

import com.converter.ResultMsg;
import com.repository.UserRepository;
import com.service.BookService;
import com.service.CharacterTransformService;
import com.service.GetBookInfoService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * 用户登录
 * Created by 54472 on 2017/11/12.
 */
@Controller
@SessionAttributes("userInfo")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier(value = "getBookInfoServiceImpl")
    private GetBookInfoService getBookInfoService;

    @Resource(name = "characterTransformServiceImpl")
    private CharacterTransformService characterTransformService;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Resource(name = "bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/")
    public String home() {
        return "redirect: /homepage";
    }

    /**
     * 登录页面
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/login")
    public String login(Model model) throws IOException {
        model.addAttribute("bookList", bookService.getRandomBookInfo().get(0));
        return "login";
    }

    /**
     * 用户登录
     * @param map
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userLogin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Object homeController(@RequestBody Map<String, String> map, Model model) {
        String account = map.get("account");
        String password = characterTransformService.encrypt(map.get("password"));

        if(userService.initUser(account, password)) {
            model.addAttribute("userInfo", account);
            return ResultMsg.success();
        } else {
            return ResultMsg.deny();
        }
    }
}