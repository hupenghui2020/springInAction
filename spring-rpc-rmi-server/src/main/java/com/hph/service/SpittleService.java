package com.hph.service;

import com.hph.model.Spittle;
import org.springframework.data.domain.Page;

/**
 * @author hph
 */
public interface SpittleService {

    /**
     * 获取分页数据
     * @param max
     * @param count
     * @return
     */
    Page<Spittle> findAllForPage(int max, int count);

    /**
     * 获取 Spittle
     * @param spittleId
     * @return
     */
    Spittle findOneSpittle(String spittleId);

    /**
     * 移除指定的 spittle
     * @param spittleId
     */
    void removeSpittle(String spittleId);

    /**
     * 保存 spittle
     * @param spittle
     */
    void saveSpittle(Spittle spittle);
}
