package com.hph.service.impl;

import com.hph.model.Spittle;
import com.hph.service.AlertService;
import org.springframework.stereotype.Component;

/**
 * @author hph
 */
@Component
public class AlertServiceImpl implements AlertService {

    @Override
    public void sendSpittleAlert(Spittle spittle) {

        System.out.println("发送消息");
    }
}
