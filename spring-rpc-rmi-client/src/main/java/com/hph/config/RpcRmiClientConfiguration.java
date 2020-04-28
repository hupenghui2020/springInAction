package com.hph.config;

import com.hph.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @author 10499
 */

@Configuration
public class RpcRmiClientConfiguration {

    /**
     * 装配 SpitterService 服务
     * @return
     */
    @Bean
    public RmiProxyFactoryBean spitterService(){

        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:1199/SpitterService");
        rmiProxyFactoryBean.setServiceInterface(SpitterService.class);
        return rmiProxyFactoryBean;
    }
}
