package com.hph.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动对缓存的支持
 * 使用方法：在需要缓存返回结果的方法上添加 Cacheable 注解即可
 * @author hph
 */

@EnableCaching
@Configuration
public class CacheConfiguration {

    /**
     * 缓存管理器
     * @return CacheManager
     */
    /*@Bean
    public CacheManager cacheManager(){
        // 该缓存管理器使用的是 ConcurrentHashMap 基于内存的缓存存储，作为生产环境是不合适的
        return new ConcurrentMapCacheManager();
    }*/

    /**
     * 使用 redis 作为缓存管理器
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    @Qualifier("redisCacheManager")
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        return RedisCacheManager.create(redisConnectionFactory);
    }

    /**
     * 使用 EhCache 作为缓存管理器
     * @param cacheManager 注入 EhCacheManagerFactoryBean 产生的 cacheManage
     * @return
     */
    @Bean
    public EhCacheCacheManager cacheCacheManager(net.sf.ehcache.CacheManager cacheManager){

        return new EhCacheCacheManager(cacheManager);
    }

    /**
     * 这里并不会将 EhCacheManagerFactoryBean 实例注册到 spring 容器中，
     * 因为 EhCacheManagerFactoryBean 是一个工厂 bean ，
     * 会注册 CacheManager 实例给上面的 EhCacheCacheManager bean 进行注入
     * @return
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){

        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("com.hph.cache.ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }

    /**
     * 使用多个缓存管理器
     * CompositeCacheManager 会迭代 managers 列表，查找缓存的值
     * @param cm ehcache 缓存管理器
     * @param rcm redis 缓存管理器
     * @return CacheManager
     */
    @Bean
    public CacheManager cacheManager(net.sf.ehcache.CacheManager cm, @Qualifier("redisCacheManager") CacheManager rcm){
        CompositeCacheManager compositeCacheManager = new CompositeCacheManager();
        List<CacheManager> managers = new ArrayList<>();
        managers.add(rcm);
        managers.add(new EhCacheCacheManager(cm));
        compositeCacheManager.setCacheManagers(managers);
        return compositeCacheManager;
    }
}
