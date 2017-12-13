package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.controller"}, useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                Controller.class, ControllerAdvice.class
        })})
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    @Bean(name = "viewResolver")
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html; charset=UTF-8");
        return viewResolver;
    }

    // 添加静态资源映射
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/statics/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/statics/js/");
        registry.addResourceHandler("/image/**").addResourceLocations("/statics/image/");
        super.addResourceHandlers(registry);
    }

    // 添加 default servlet 支持
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
