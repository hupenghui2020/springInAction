package com.hph.service.impl;

import com.hph.data.SpittleRepository;
import com.hph.model.Spittle;
import com.hph.service.SpittleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 10499
 */
@Service
public class SpittleServiceImpl implements SpittleService {

    @Resource
    private SpittleRepository spittleRepository;

    @Override
    public Page<Spittle> findAllForPage(int max, int count) {
        return spittleRepository.findAll(PageRequest.of(max, count));
    }

    @Override
    public Spittle findOneSpittle(String spittleId) {
        return spittleRepository.findOneSpittle(spittleId);
    }

    @Override
    public void removeSpittle(String spittleId) {
        spittleRepository.removeSpittle(spittleId);
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        spittleRepository.saveSpittle(spittle);
    }
}
