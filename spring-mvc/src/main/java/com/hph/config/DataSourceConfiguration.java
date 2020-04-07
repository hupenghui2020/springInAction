package com.hph.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author hph
 */
@Configuration
public class DataSourceConfiguration {

    /**
     * 数据源
     * @return
     */
    @Profile("qa")
    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("");
        basicDataSource.setUrl("");
        basicDataSource.setUsername("");
        basicDataSource.setPassword("");
        basicDataSource.setInitialSize(5);
        return  basicDataSource;
    }

    /**
     * JDBC 模板
     * @param dataSource 数据源
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
