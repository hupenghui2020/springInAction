package com.hph.service.impl;

import com.hph.model.Spittle;
import com.hph.service.SpittleService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 10499
 */
@Service
public class SpittleServiceImpl implements SpittleService {

    @Resource
    private JmsTemplate jmsTemplate;

    @Override
    public Object findAll(int max,int count) {
        return null;
    }

    @Override
    public Object findOneSpittle(String spittleId) {
        return null;
    }

    @Override
    public void removeSpittle(String spittleId) {
        jmsTemplate.convertAndSend(spittleId);
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        jmsTemplate.convertAndSend(spittle);
    }
}
