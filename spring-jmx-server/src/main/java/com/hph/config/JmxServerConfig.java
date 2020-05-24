package com.hph.config;

import com.hph.web.SpitterController;
import com.hph.web.SpitterControllerManagedOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 10499
 */

@Configuration
public class JmxServerConfig {

    /**
     * 将 bean 导出为 MBean
     * @param spitterController
     * @param assembler
     * @return
     */
    @Bean
    public MBeanExporter mBeanExporter(SpitterController spitterController, MBeanInfoAssembler assembler){

        MBeanExporter mBeanExporter = new MBeanExporter();
        Map<String,Object> beans = new HashMap<>(1);
        beans.put("spitter:name=SpitterController", spitterController);
        mBeanExporter.setBeans(beans);
        mBeanExporter.setAssembler(assembler);
        /*解决冲突（可能多个 MBean 的名称一样：比如多个叫 SpitterController 的 MBean）
        三种选择：
            FAIL_ON_EXISTING：如果已存在相同名字的 MBean ，则失败（默认行为）；
            IGNORE_EXISTING：忽略冲突，同时也不注册新的 MBean；
            REPLACE_EXISTING：用新的 MBean 覆盖已存在的 MBean*/
        mBeanExporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
        return mBeanExporter;
    }

    /**
     * 信息装配器
     * 通过为 bean 增加接口来选择暴露的方法
     * 用于对 MBean 的属性和操作进行更细粒度的控制
     * @return
     */
    @Bean
    public InterfaceBasedMBeanInfoAssembler assembler(){

        InterfaceBasedMBeanInfoAssembler assembler = new InterfaceBasedMBeanInfoAssembler();
        Class<?>[] classes = new Class<?>[] { SpitterControllerManagedOperations.class };
        assembler.setManagedInterfaces(classes);
        return assembler;
    }
}
