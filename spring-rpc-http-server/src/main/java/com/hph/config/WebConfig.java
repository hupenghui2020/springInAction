package com.hph.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import java.util.Properties;

/**
 * 该注解激活web功能
 * @author com.hph
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.hph.service.impl")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HandlerMapping httpInvokerMapping(){
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/spitter.service", "httpInvokerServiceExporter");
        mapping.setMappings(mappings);
        return mapping;
    }
}
