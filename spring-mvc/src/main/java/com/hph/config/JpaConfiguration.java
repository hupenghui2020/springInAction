package com.hph.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * JPA方式持久化数据
 * EnableJpaRepositories 注解是spring data jpa的实现，通过该注解对指定的包进行扫描，并自动生成接口的实现
 * @author hph
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.hph.data")
public class JpaConfiguration {

    /**
     * （非spring data jpa的实现，通过 entityManager来进行持久化的操作 ）
     * 这里用的是
     * 容器实体管理器工厂bean
     * 当然也可以用应用程序实体管理器工厂bean LocalEntityManagerFactoryBean
     * 但是大部分配置需要在persistence.xml文件中配置
     * 这里统一交给spring管理
     * @param dataSource
     * @param jpaVendorAdapter
     * @return
     */
    /*@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        // 设置实体类包，扫描并查找带有@Entity注解的类
        entityManagerFactoryBean.setPackagesToScan("com.hph.model");
        return entityManagerFactoryBean;
    }*/

    /**
     * JNDI方式获取entityManagerFactory
     * @return
     */
    /*@Bean
    public JndiObjectFactoryBean entityManagerFactory(){
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/SpitterDS");
        return jndiObjectFactoryBean;
    }*/

    /**
     * JPA厂商适配器（JPA的实现），这里用的是 hibernate
     * @return JpaVendorAdapter
     */
    /*@Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.HSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
        return hibernateJpaVendorAdapter;
    }*/
}
