package com.hph.config;


import com.hph.web.SpitterControllerManagedOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import java.net.MalformedURLException;


/**
 * @author 10499
 */

@Configuration
public class JmxClientConfig {

    @Bean
    public MBeanServerConnectionFactoryBean connectionFactoryBean() throws MalformedURLException {

        MBeanServerConnectionFactoryBean connectionFactoryBean = new MBeanServerConnectionFactoryBean();
        connectionFactoryBean.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/spitter");
        return connectionFactoryBean;
    }

    /**
     * 远程 MBean 的远程代理工厂，提供代理实例访问远程 MBean
     * @param mBeanServerConnection
     * @return
     * @throws MalformedObjectNameException
     */
    @Bean
    public MBeanProxyFactoryBean mBeanProxyFactoryBean(MBeanServerConnection mBeanServerConnection) throws MalformedObjectNameException {
        MBeanProxyFactoryBean proxyFactoryBean = new MBeanProxyFactoryBean();
        proxyFactoryBean.setObjectName("");
        proxyFactoryBean.setServer(mBeanServerConnection);
        proxyFactoryBean.setProxyInterface(SpitterControllerManagedOperations.class);
        return proxyFactoryBean;
    }
}
