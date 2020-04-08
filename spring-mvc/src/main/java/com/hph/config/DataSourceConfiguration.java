package com.hph.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author hph
 */
@Configuration
public class DataSourceConfiguration {

    /**
     * 数据源
     * @return DataSource
     */
    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        basicDataSource.setInitialSize(5);
        return  basicDataSource;
    }

    /**
     * JDBC模板方式，后续用JPA方式代替
     * JDBC 模板
     * @param dataSource 数据源
     * @return JdbcTemplate
     */
    /*@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }*/
}
