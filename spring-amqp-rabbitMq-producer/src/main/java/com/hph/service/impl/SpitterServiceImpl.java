package com.hph.service.impl;

import com.hph.model.Spitter;
import com.hph.service.SpitterService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author 10499
 */
@Service
public class SpitterServiceImpl implements SpitterService {

    @Resource
    private JmsTemplate jmsTemplate;

    @Override
    public void save(Spitter spitter) {
        jmsTemplate.convertAndSend(spitter);
    }

    @Override
    public Object findOne(Spitter spitter) {
        return null;
    }
}
