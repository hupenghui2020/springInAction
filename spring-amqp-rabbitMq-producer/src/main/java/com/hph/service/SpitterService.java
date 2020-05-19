package com.hph.service;

import com.hph.model.Spitter;

public interface SpitterService {
    void save(Spitter spitter);

    Object findOne(Spitter spitter);
}
