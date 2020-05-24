package com.hph.config;

import com.hph.handler.MarcoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author 10499
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 将 /marcopolo 注册为 STOMP 端点，
        registry.addEndpoint("/marcopolo").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // 目的地为消息代理，用于直接响应监控该路径的客户端
        registry.enableSimpleBroker("/queue", "/topic");
        // 目的地为应用程序，/app 前缀的消息交由 @MessageMapping 注解的控制器方法处理
        registry.setApplicationDestinationPrefixes("/app");
    }
}
