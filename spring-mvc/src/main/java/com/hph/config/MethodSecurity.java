package com.hph.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * 启用基于注解的方法安全性
 * 直接作用在方法上的注解保护方式
 * @Secured spring 特定的注解
 * @RolesAllowed java的标准注解
 * (这里是激活 @Secured 方式)
 * @author com.hph
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurity extends GlobalMethodSecurityConfiguration {


}
