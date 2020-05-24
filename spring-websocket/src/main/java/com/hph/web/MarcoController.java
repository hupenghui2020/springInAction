package com.hph.web;

import com.hph.model.Shout;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 * @author 10499
 */
@Controller
public class MarcoController {

    @MessageMapping("/marco")
    @SubscribeMapping
    public void handleShout(Shout incoming){
        System.out.println(incoming.getMessage());
    }
}
