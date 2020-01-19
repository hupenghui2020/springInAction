package com.hph.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;


/**
 * @author hph
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
// @ContextConfiguration(locations = "spring-ioc.xml")
// @ContextConfiguration(classes = SoundSystemConfig.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Resource
    private CompactDisc compactDisc;

    @Autowired
    private MediaPalyer cdPlayer;

    @Test
    public void cdShouldNotBeNull(){

        assertNotNull(compactDisc);
        assertNotNull(cdPlayer);
    }

    @Test
    public void play(){

        cdPlayer.play();
    }
}
