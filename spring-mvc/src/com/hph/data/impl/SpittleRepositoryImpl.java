package com.hph.data.impl;

import com.hph.data.SpittleRepository;
import com.hph.model.Spittle;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hph
 */

@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }
}
