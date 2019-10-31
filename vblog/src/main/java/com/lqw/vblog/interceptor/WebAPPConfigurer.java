package com.lqw.vblog.interceptor;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAPPConfigurer implements WebMvcConfigurer {

    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        InterceptorRegistration registration=interceptorRegistry.addInterceptor(new MyInterceptor());
        registration.addPathPatterns("/admin/article/**");
        registration.excludePathPatterns("/login");

    }
}
