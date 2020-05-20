package com.hph.handler;

import com.hph.model.Spittle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author hph
 */
@Component
public class AlertHandler{

    public void sendSpittleAlert(Spittle spittle) {

        System.out.println("接受的信息：" + spittle);
    }
}
