package com.example.CRUD.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("allUsers");
        registry.addViewController("/user").setViewName("user");
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringRoleConverter());
    }
}
