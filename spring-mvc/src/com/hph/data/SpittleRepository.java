package com.hph.data;

import com.hph.model.Spittle;

import java.util.List;


/**
 * @author hph
 */
public interface SpittleRepository {

    /**
     * 获取Spittle列表
     * @param max
     * @param count
     * @return
     */
    List<Spittle> findSpittles(long max, int count);

    /**
     * 根据spittle id 获取指定的spittle
     * @param spittleId
     * @return
     */
    Spittle findOne(Long spittleId);
}
