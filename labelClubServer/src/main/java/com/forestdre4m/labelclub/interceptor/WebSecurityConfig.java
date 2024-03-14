package com.forestdre4m.labelclub.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
    @Bean
    public MyInterceptor getMyInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/label/login")
                .excludePathPatterns("/label/register")
                .excludePathPatterns("/artist/login")
                .excludePathPatterns("/artist/register")
                
                .excludePathPatterns("/files/download/**")
				.excludePathPatterns("/files/front/**")
                .excludePathPatterns("/upload/**")
				.excludePathPatterns("/front/**")
                .excludePathPatterns("/logout");
    }
}
