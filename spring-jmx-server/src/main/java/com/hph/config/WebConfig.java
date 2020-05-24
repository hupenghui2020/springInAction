package com.hph.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 该注解激活web功能
 * @author com.hph
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

}
