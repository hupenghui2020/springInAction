package com.hph.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

/**
 * 将多个bean分开配置
 * @author com.hph
 */

@Configuration
// @ComponentScan(basePackageClasses = CompactDisc.class)
@PropertySource("classpath:/com/com.hph/demo/app.properties")
public class CDConfig {

    /*@Bean
    public CompactDisc sgtPeppers(){

        return new SgtPeppers();
    }*/
}
