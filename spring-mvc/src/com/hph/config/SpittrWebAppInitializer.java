package com.hph.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 使用这种方式来配置应用上下问来替代传统的web.xml配置方式
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

        System.out.println("-----------------------------");
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
        System.out.println("-----------------------------");

        return new Class<?>[]{ WebConfig.class };
    }

    /**
     * 请求映射规则
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        System.out.println("-----------------------------");
        return new String[]{ "/" };
    }
}
