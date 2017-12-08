package com.config;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by 54472 on 2017/11/12.
 */
@Configuration
@ComponentScan(basePackages = {"com.config", "com.dao", "com.service"})
@Import(DataSourceConfig.class)
public class RootConfig {

        @Bean
        public BeanNameAutoProxyCreator proxyCreator() {
                BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
                proxyCreator.setProxyTargetClass(true);
                proxyCreator.setBeanNames("*ServiceImpl");
                proxyCreator.setInterceptorNames("transactionInterceptor");
                return proxyCreator;
        }
}
