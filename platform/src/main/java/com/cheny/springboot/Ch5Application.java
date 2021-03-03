package com.cheny.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.cheny.springboot.dao")
@EnableTransactionManagement(proxyTargetClass = true)
@ServletComponentScan(basePackages = {"com.cheny.springboot.servlet","com.cheny.springboot.Filter"})
public class Ch5Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Ch5Application.class, args);
    }


    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Ch5Application.class);
    }*/
}
