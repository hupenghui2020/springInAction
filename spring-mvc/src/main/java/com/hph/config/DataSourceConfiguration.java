package com.hph.config;

import com.hph.model.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=false&serverTimezone=UTC");
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

    /**
     * redis 连接工厂
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    /**
     * redis 模板
     * 这里有两个用处：NOSQL 和 作为缓存管理器
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // key 序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value 序列化方式
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Product.class));
        return redisTemplate;
    }
}
