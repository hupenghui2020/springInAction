package com.hph.config;

import com.hph.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * @author 10499
 */

@Configuration
public class RpcRmiServerConfiguration {

    /**
     * 导出 SpitterService 服务
     * @param spitterService
     * @return
     */
    @Bean
    public RmiServiceExporter rmiServiceExporter(SpitterService spitterService){

        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(spitterService);
        rmiServiceExporter.setServiceName("SpitterService");
        rmiServiceExporter.setRegistryHost("127.0.0.1");
        rmiServiceExporter.setRegistryPort(1199);
        rmiServiceExporter.setServiceInterface(SpitterService.class);
        return rmiServiceExporter;
    }
}
