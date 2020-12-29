package com.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan("com")
public class SpringWeb extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver GetInternalResourceViewResolver() {
        InternalResourceViewResolver ViewResolver = new InternalResourceViewResolver();
        ViewResolver.setViewClass(JstlView.class);
        ViewResolver.setPrefix("/WEB-INF/views/");
        ViewResolver.setSuffix(".jsp");
        return ViewResolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver Resolver = new CommonsMultipartResolver();
        Resolver.setDefaultEncoding(("utf-8"));
        return Resolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**","/app/**").addResourceLocations("/resource/");
    }
}