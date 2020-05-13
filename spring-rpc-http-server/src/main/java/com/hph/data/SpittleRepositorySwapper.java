package com.hph.data;

import com.hph.model.Spittle;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author com.hph
 */
public interface SpittleRepositorySwapper {

    /**
     * 通过 id 查找
     * @param id id
     * @return Spittle
     */
    Spittle findOneSpittle(String id);

    /**
     * 保存
     * 执行 update/delete 操作需要 Transactional
     * @param spittle
     * @return
     */

    @Transactional(rollbackFor = Exception.class)
    Spittle saveSpittle(Spittle spittle);

    /**
     * 移除
     * CacheEvict：当数据库中的数据被删除时，我们可能需要删除缓存中路劲为 spittleCache -> spittleId key对应的条目
     *
     * 执行 update/delete 操作需要 Transactional
     * @param spittleId
     */
    @Transactional(rollbackFor = Exception.class)
    void removeSpittle(String spittleId);
}
