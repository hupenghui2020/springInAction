package com.hph.config;

import com.hph.demo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hph
 */
@Configuration
@ComponentScan(basePackages = "com.hph.demo")
@EnableAspectJAutoProxy
public class ConcertConfig {

    /*@Bean
    public Audience audience(){
        return new Audience();
    }*/

    @Bean
    public EncoreableIntroducer encoreableIntroducer(){
        return new EncoreableIntroducer();
    }

    @Bean
    public Performance performance(){
        return new PerformanceImpl();
    }
}
