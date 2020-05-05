package com.hph.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 多种bean配置方式组合
 * @author com.hph
 */
@Configuration
// @ImportResource("classpath:cd-config.xml")
// @Import({CDPlayerConfig.class, CDConfig.class})
// @Import({CDPlayerConfig.class})
public class SoundSystemConfig {
}
