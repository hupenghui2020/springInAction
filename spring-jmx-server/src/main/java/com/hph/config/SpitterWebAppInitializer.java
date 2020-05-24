package com.hph.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * servlet初始类：使用这种方式来配置应用上下问来替代传统的web.xml配置方式
 * AbstractAnnotationConfigDispatcherServletInitializer
 * @author com.hph
 */
public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * spring应用上下文的配置
     * 用于加载spring的bean，java配置方式，RootConfig java类中
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class<?>[]{ RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebConfig.class };
    }

    /**
     * 请求映射规则
     * @return
     */
    @Override
    protected String[] getServletMappings() {

        return new String[]{ "/spitter/*" };
    }
}

