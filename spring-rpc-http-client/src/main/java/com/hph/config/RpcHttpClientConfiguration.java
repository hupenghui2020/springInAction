package com.hph.config;

import com.hph.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * @author 10499
 */

@Configuration
public class RpcHttpClientConfiguration {

    /**
     * 通过 HTTP 访问服务
     * @return
     */
    @Bean
    public HttpInvokerProxyFactoryBean spitterService(){

        HttpInvokerProxyFactoryBean proxyFactoryBean = new HttpInvokerProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("http://localhost:8080/spitter/spitter.service");
        proxyFactoryBean.setServiceInterface(SpitterService.class);
        return proxyFactoryBean;
    }
}
