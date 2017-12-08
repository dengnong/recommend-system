package com.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * Created by 54472 on 2017/12/8.
 */
@Aspect
@Component
@ImportResource("classpath:/aop-config.xml")
public class AspectConfig {
    @Pointcut("execution(* com.service.*.*(..))")
    public void serviceAnnotatedClass() {

    }

}
