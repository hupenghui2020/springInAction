package com.hph.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * @author hph
 */
@Configuration
@ComponentScan(basePackages = {"com.hph"},
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {

    /**
     * 多语言的实现
     * @return MessageSource
     */
    @Bean
    public MessageSource messageSource(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        // 根据读取不同名字的message文件实现多语言
        messageSource.setBasename("/WEB-INF/message");

        messageSource.setCacheSeconds(10);

        return messageSource;
    }
}
