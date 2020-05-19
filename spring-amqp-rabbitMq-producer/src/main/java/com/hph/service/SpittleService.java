package com.hph.service;

import com.hph.model.Spittle;

public interface SpittleService {

    Object findAll(int max,int count);

    Object findOneSpittle(String spittleId);

    void removeSpittle(String spittleId);

    void saveSpittle(Spittle spittle);
}
