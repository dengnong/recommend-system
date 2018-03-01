package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by 54472 on 2018/2/28.
 */
@Controller
@SessionAttributes("userInfo")
public class LogoutController {

    @RequestMapping("logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "login";
    }
}
