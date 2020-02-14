package com.hph.data.impl;

import com.hph.data.SpitterRepository;
import com.hph.data.SpittleRepository;
import com.hph.model.Spitter;
import com.hph.model.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hph
 */

@Component
public class SpitterRepositoryImpl implements SpitterRepository {

    private List<Spitter> spitterList = new ArrayList<>();

    @Override
    public void save(Spitter spitter) {

        spitterList.add(spitter);
    }

    @Override
    public Spitter findByUsername(String username) {

        return spitterList.stream().filter(spitter -> spitter.getUsername().equals(username)).findFirst().orElse(null);
    }
}
