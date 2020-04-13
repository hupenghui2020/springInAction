package com.hph.data;

import com.hph.model.Spittle;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author hph
 */
public interface SpittleRepositorySwapper {

    /**
     * 通过 id 查找
     * 使用 Cacheable 进行返回结果的缓存，下次调用该方法时会直接去缓存中取
     * 缓存切面拦截调用并在缓存中查找之前名 spittleCache 存储的返回值
     * 缓存的 key 为方法参数 id
     * spittleCache：见 ehcache.xml 配置文件
     * unless：如果方法返回结果中的 message 属性包含 NoCache ，则不进行缓存当前结果
     * condition：如果方法请求参数 id 小于 10 ，则缓存失效，不会去缓存中查找，返回的结果也不会进行缓存
     * @param id id
     * @return Spittle
     */
    @Cacheable(value = "spittleCache",
            unless = "#result.message.contains('NoCache')",
            condition = "#id != 10")
    Spittle findOneSpittle(String id);

    /**
     * 保存
     * 使用 CachePut 注解仅仅可以使返回的结果放入缓存中，下次调用该方法还是会直接调用
     * 作为预热功能
     * 下次调用 findOne 方法的时候通过 spittleCache -> id key 的路径直接去缓存找
     * key：指定 key 为缓存的key，因为 findOne 方法是通过 id 作为 key 去缓存中查找的
     * @param spittle
     * @return
     */
    @CachePut(value = "spittleCache",
            key = "#result.id")
    Spittle saveSpittle(Spittle spittle);

    /**
     * 移除
     * CacheEvict：当数据库中的数据被删除时，我们可能需要删除缓存中路劲为 spittleCache -> spittleId key对应的条目
     * @param spittleId
     */
    @CacheEvict(value = "spittleCache")
    void removeSpittle(String spittleId);
}
