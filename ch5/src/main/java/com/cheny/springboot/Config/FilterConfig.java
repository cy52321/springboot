package com.cheny.springboot.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/*@Configuration*/
public class FilterConfig {
    @Bean
    public FilterRegistrationBean myfilterbean(){

        /*字符过滤器*/
        CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("utf-8");

        /*过滤器*/
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(characterEncodingFilter);

        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
