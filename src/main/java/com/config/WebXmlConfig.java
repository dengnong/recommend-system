//package com.config;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.filter.CharacterEncodingFilter;
//
//import javax.servlet.FilterRegistration;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
///**
// *
// */
//public class WebXmlConfig implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        // CharacterEncodingFilter 过滤器
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
//        FilterRegistration.Dynamic characterEncodingConfig = servletContext.addFilter(
//                "characterEncodingFilter", characterEncodingFilter
//        );
//    }
//}
