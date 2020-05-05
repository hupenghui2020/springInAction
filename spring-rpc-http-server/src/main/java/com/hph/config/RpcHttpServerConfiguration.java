package com.hph.config;

import com.hph.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * @author 10499
 */

@Configuration
public class RpcHttpServerConfiguration {

    /**
     * 导出 SpitterService 服务
     * 相当于 spring 的 mvc 控制器
     * @param spitterService
     * @return
     */
    @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(SpitterService spitterService){

        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(spitterService);
        httpInvokerServiceExporter.setServiceInterface(SpitterService.class);
        return httpInvokerServiceExporter;
    }
}
