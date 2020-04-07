package com.hph.data.impl;

import com.hph.data.SpittleRepository;
import com.hph.model.Spittle;
import com.hph.model.Spitter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hph
 */

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

    private List<Spittle> spittleList = new ArrayList<>();

    private List<Spitter> spitterList = new ArrayList<>();

    @Override
    public List<Spittle> findSpittles(long max, int count) {

        Spittle spittle1 = new Spittle("sdaw1", new Date(), 1d, 1d);
        Spittle spittle2 = new Spittle("sdaw2", new Date(), 2d, 2d);
        Spittle spittle3 = new Spittle("sdaw3", new Date(), 3d, 3d);
        Spittle spittle4 = new Spittle("sdaw4", new Date(), 4d, 4d);

        spittleList.add(spittle1);
        spittleList.add(spittle2);
        spittleList.add(spittle3);
        spittleList.add(spittle4);
        return spittleList;
    }

    @Override
    public Spittle findOne(Long spittleId) {

        return spittleList.get(Integer.parseInt(spittleId.toString()));
    }

    @Override
    public void save(Spitter spitter) {

        spitterList.add(spitter);
    }

    @Override
    public Spitter findByUsername(String username) {

        return spitterList.stream().filter(spitter -> spitter.getUsername().equals(username)).findFirst().orElse(null);
    }
}
