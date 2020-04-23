package com.hph.service.impl;

import com.hph.data.SpitterRepository;
import com.hph.model.Spitter;
import com.hph.service.SpitterService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author 10499
 */
@Service
public class SpitterServiceImpl implements SpitterService {

    @Resource
    SpitterRepository spitterRepository;

    @Override
    public void save(Spitter spitter) {

        spitterRepository.save(spitter);
    }

    @Override
    public Spitter findOneByUsername(String username) {

        Spitter spitter = new Spitter();
        spitter.setUsername(username);
        return spitterRepository.findOne(Example.of(spitter)).orElse(null);
    }
}
