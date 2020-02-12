package com.hph.data.impl;

import com.hph.data.SpittleRepository;
import com.hph.model.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hph
 */

@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {

        List<Spittle> spittleList = new ArrayList<>(4);

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
}
