package com.hph.handler;

import com.hph.data.SpitterRepository;
import com.hph.model.Spitter;
import org.springframework.stereotype.Component;

/**
 * @author 10499
 */
@Component
public class SpitterHandler {

    private SpitterRepository spitterRepository;

    public void save(Spitter spitter) {
        spitterRepository.save(spitter);
    }
}
