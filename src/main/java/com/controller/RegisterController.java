package com.controller;

import com.converter.ResultMsg;
import com.entity.User;
import com.repository.UserRepository;
import com.service.CharacterTransformService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 用户注册
 * Created by 54472 on 2017/12/19.
 */
@Controller
@SessionAttributes("userInfo")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Resource(name = "characterTransformServiceImpl")
    private CharacterTransformService characterTransformService;

    /**
     * 用户注册
     * @param map
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userRegister", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Object registerUser(@RequestBody Map<String, String> map, Model model) {
        String account = map.get("account");
        String password = characterTransformService.encrypt(map.get("password"));
        if(userService.initUserExist(account)) {
            return ResultMsg.exist();
        } else {
            User user = new User(account, password, LocalDateTime.now(), true);
            userRepository.save(user);
            model.addAttribute("userInfo", account);
            return ResultMsg.success();
        }
    }
}
