package com.controller;

import com.converter.ResultMsg;
import com.entity.User;
import com.repository.UserRepository;
import com.service.CharacterTransformService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by 54472 on 2017/12/19.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Resource(name = "characterTransformServiceImpl")
    private CharacterTransformService characterTransformService;

    @ResponseBody
    @RequestMapping(value = "userRegister", method = RequestMethod.POST)
    public Object registerUser(@RequestBody Map<String, String> map) {
        String account = map.get("account");
        String password = characterTransformService.encrypt(map.get("password"));
        User user = new User(account, password, LocalDateTime.now(), true);
        userRepository.save(user);
        return ResultMsg.success();
    }
}
