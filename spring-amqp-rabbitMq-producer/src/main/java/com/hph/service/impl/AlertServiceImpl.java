package com.hph.service.impl;

import com.hph.model.Spittle;
import com.hph.service.AlertService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hph
 */
@Component
public class AlertServiceImpl implements AlertService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendSpittleAlert(Spittle spittle) {

        rabbitTemplate.convertAndSend("spittle.alert.exchange", "spittle.alerts",spittle);
    }
}
