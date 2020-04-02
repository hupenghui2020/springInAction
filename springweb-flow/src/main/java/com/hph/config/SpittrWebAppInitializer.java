package com.hph.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;


/**
 * servlet初始类：使用这种方式来配置应用上下问来替代传统的web.xml配置方式
 * @author hph
 */

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * spring应用上下文的配置
     * 用于加载spring的bean，java配置方式，RootConfig java类中
     * @return
     */

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class<?>[]{ RootConfig.class };
    }

    /**
     * web应用上下文的配置，通过ContextLoaderListener
     * 用于加载web组件的bean，java的配置方式，Webconfig java类中
     * 控制器、视图解析器、处理器映射器
     * @return
     */

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{ WebConfig.class };
    }


    /**
     * 请求映射规则
     * @return
     */

    @Override
    protected String[] getServletMappings() {

        return new String[]{ "/" };
    }


    /**
     * servlet对multipart 请求的一些自定义配置
     * @param registration
     */

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // 自定义配置：文件上次时的临时目录，当表单上次文件时，会先上次到这个临时目录
        registration.setMultipartConfig(new MultipartConfigElement("C:\\Users\\hph\\Desktop\\temp"));
    }
}

