package com.hph.service;

import com.hph.model.Spitter;

/**
 * @author com.hph
 */
public interface SpitterService {

    /**
     * 保存 spitter
     * @param spitter
     */
    void save(Spitter spitter);

    /**
     * 通过 username 获取 spitter 对象
     * @param username
     * @return
     */
    Spitter findOneByUsername(String username);
}
