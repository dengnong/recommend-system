package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by 54472 on 2017/12/14.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);

        http.addFilterBefore(characterEncodingFilter, CsrfFilter.class)
                .formLogin()
                .loginPage("/index")
                .defaultSuccessUrl("/home")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .authorizeRequests()
                .anyRequest().permitAll();
    }
}
