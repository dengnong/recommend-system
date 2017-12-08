package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by 54472 on 2017/11/12.
 */
@Configuration
@ComponentScan(basePackages = {"com"},
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class RootConfig {
}
