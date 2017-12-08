package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by 54472 on 2017/11/12.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
