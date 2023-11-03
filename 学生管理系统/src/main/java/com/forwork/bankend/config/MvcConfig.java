package com.forwork.bankend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  拦截全局，放行login
        registry.addInterceptor(new LoginHandleInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
}
