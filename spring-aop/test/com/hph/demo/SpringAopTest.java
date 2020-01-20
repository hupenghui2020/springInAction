package com.hph.demo;

import com.hph.config.ConcertConfig;
import com.hph.config.TrackCounterConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = ConcertConfig.class)
@ContextConfiguration(locations = "spring-aop.xml")
// @ContextConfiguration(classes = TrackCounterConfig.class)
public class SpringAopTest {

    @Autowired
    private Performance performance;

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void test(){

        performance.perform();
    }

    @Test
    public void testPlaying(){

        compactDisc.playTrack(1);
    }

    /**
     * 测试新引进的接口
     */
    @Test
    public void testEncoreable(){

        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();
    }
}
