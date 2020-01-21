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
}
