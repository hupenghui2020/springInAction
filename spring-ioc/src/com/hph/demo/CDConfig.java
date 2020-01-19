package com.hph.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 将多个bean分开配置
 * @author hph
 */

@Configuration
@ComponentScan(basePackageClasses = CompactDisc.class)
public class CDConfig {

    /*@Bean
    public CompactDisc sgtPeppers(){

        return new SgtPeppers();
    }*/
}
