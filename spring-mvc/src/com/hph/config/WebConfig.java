package com.hph.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author hph
 */
@Configuration
// 该注解激活web功能
@EnableWebMvc
@ComponentScan(basePackages = "com.hph.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置jsp的视图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        // 设置视图前缀
        viewResolver.setPrefix("/WEB-INF/views/");

        // 设置视图后缀
        viewResolver.setSuffix(".jsp");

        viewResolver.setExposeContextBeansAsAttributes(true);

        return viewResolver;
    }

    /**
     * 将静态资源的请求交给servlet容器的默认servlet处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }
}
