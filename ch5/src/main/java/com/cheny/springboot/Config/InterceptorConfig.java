package com.cheny.springboot.Config;

import com.cheny.springboot.Interceptor.StudentInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPath={"/**"};
        String[] excludePath={"/login2/**", "","/login"};
        registry.addInterceptor(new StudentInterceptor()).addPathPatterns(addPath).excludePathPatterns(excludePath);
    }
}
