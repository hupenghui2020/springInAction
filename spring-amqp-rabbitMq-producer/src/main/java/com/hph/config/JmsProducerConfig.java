package com.hph.config;


import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;

/**
 * @author 10499
 */
@Configuration
public class JmsProducerConfig {

    /**
     * MQ 连接工厂
     * @return
     */
    @Bean
    public ConnectionFactory activeMQConnectionFactory(){

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        return activeMQConnectionFactory;
    }

    /**
     * 队列模式
     * 定义队列
     * @return
     */
    @Bean
    public ActiveMQQueue activeMQQueue(){
        ActiveMQQueue activeMQQueue = new ActiveMQQueue();
        activeMQQueue.setPhysicalName("spitter.alert.queue");
        return activeMQQueue;
    }

    /**
     * 订阅模式
     * 定义主题
     * @return
     */
    @Bean
    public ActiveMQTopic activeMQTopic(){
        ActiveMQTopic activeMQTopic = new ActiveMQTopic();
        activeMQTopic.setPhysicalName("spitter.alert.topic");
        return activeMQTopic;
    }

    /**
     * 定义消息转换器
     * @return
     */
    /*@Bean
    public MessageConverter messageConverter(){
        return new MappingJackson2MessageConverter();
    }*/

    /**
     * 定义 jms 模板
     * @param activeMQConnectionFactory
     * @param activeMQTopic
     * @param messageConverter
     * @return
     */
    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory,
                                   ActiveMQTopic activeMQTopic,
                                   MessageConverter messageConverter){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
        // 设置目的地
        jmsTemplate.setDefaultDestination(activeMQTopic);
        // jmsTemplate.setMessageConverter(messageConverter);
        return jmsTemplate;
    }
}
