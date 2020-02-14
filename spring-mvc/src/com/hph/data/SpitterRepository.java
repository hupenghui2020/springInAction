package com.hph.data;

import com.hph.model.Spitter;
import com.hph.model.Spittle;

import java.util.List;


/**
 * @author hph
 */
public interface SpitterRepository {

    /**
     * 保存spitter
     * @param spitter
     */
    void save(Spitter spitter);

    /**
     * 获取指定的spitter
     * @param username
     * @return
     */
    Spitter findByUsername(String username);
}
