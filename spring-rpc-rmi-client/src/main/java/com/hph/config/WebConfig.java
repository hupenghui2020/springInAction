package com.hph.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hph
 */
@Configuration
 // 该注解激活web功能
@EnableWebMvc
@ComponentScan(basePackages = "com.hph.web")
public class WebConfig implements WebMvcConfigurer {

    /**
     * 将静态资源的请求交给servlet容器的默认servlet处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }

    /**
     * multipart解析器：使用servlet3.0自带对multipart请求的文件参数进行解析
     * 如果控制器中的方法，有使用 Part 作为请求参数，则这个就可以不需要
     * @return MultipartResolver
     */
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
