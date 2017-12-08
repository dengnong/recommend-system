package com.web;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by 54472 on 2017/12/8.
 */
@WebServlet(name="druidMonitor", urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "allow", value= "127.0.0.1"),
        @WebInitParam(name = "loginUsername", value = "admin"),
        @WebInitParam(name = "loginPassword", value = "root"),
        @WebInitParam(name = "resetEnable", value = "false")
})

public class DruidServletMonitor {
    private static final long serialVersionUID = 1L;
}
