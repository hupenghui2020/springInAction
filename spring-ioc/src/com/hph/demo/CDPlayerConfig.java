package com.hph.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自动装配的组件扫描
 * @author 10499
 */

@Configuration
// 引入其它java配置类（这里我们统一放在SoundSystemConfig进行配置）
// @Import(CDConfig.class)
// @ComponentScan // 默认是当前配置文件所在的包
// @ComponentScan(basePackageClasses = CompactDisc.class) // 扫描CompactDisc所在的包
// 引入外部属性值文件
@PropertySource("classpath:/com/com.hph/demo/app.properties")
public class CDPlayerConfig {

    @Autowired
    private Environment environment;

    /**
     * 使用java方式进行显示配置
     * bean id默认为方法名
     * @return
     */
    @Bean
    // 使用不同环境配置
    // @Profile("dev")
    // 标示首选的bean
    // @Primary
    // 限定符，可以与 @bean、@Component等一起使用
    // @Qualifier("test")
    public CompactDisc sgtPeppers(){

        return new SgtPeppers();
    }

    @Bean
    @Primary
    // @Profile("prod")
    public CompactDisc blankDisc(){

        List<String> list = new ArrayList<>();
        list.add("Sgt. Pepper's Lonely Hearts Club Band");
        list.add("With a Little Help from My Friends");
        list.add("Lucy in the Sky with Diamonds");
        list.add("Getting Better");
        list.add("Fixing a Hole");
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setArtist(environment.getProperty("artist"));
        blankDisc.setTitle(environment.getProperty("title"));
        blankDisc.setTracks(list);
        return blankDisc;
    }

    /**
     * 这种方式需要注入的bean再同一个配置方法类中
     * @return
     */
    /*@Bean
    public CDPlayer cdPlayer(){

        // java方式注入CompactDisc bean
        return new CDPlayer(sgtPeppers());
    }*/

    /**
     * 这种方式比较好，需要依赖注入的bean不需要配置在同一配置类中
     * @param compactDisc
     * @return
     */
    @Bean
    public MediaPalyer cdPlayer(CompactDisc compactDisc){

        return new CDPlayer(compactDisc);
    }

    @Bean
    public MagicBean magicBean(){

        return new MagicBean();
    }
}
