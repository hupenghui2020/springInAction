package com.hph.config;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * servlet初始类：使用这种方式来配置应用上下问来替代传统的web.xml配置方式
 * AbstractAnnotationConfigDispatcherServletInitializer
 * @author com.hph
 */

public class SpitterWebAppInitializer extends AbstractContextLoaderInitializer {
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(RootConfig.class);
        return applicationContext;
    }
}

