package com.hph.config;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


/**
 * servlet初始类：使用这种方式来配置应用上下问来替代传统的web.xml配置方式
 * AbstractAnnotationConfigDispatcherServletInitializer
 * @author hph
 */

public class SpitterWebAppInitializer extends AbstractContextLoaderInitializer {


    @Override
    protected WebApplicationContext createRootApplicationContext() {

        return ContextLoader.getCurrentWebApplicationContext();
    }

}

