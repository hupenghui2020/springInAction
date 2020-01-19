package com.hph.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;


/**
 * @author hph
 */
@RunWith(SpringJUnit4ClassRunner.class)
<<<<<<< Updated upstream:spring-ioc/test/com.hph.demo/CDPlayerTest.java
@ContextConfiguration(locations = "/spring-config.xml")
=======
//@ContextConfiguration(classes = CDPlayerConfig.class)
>>>>>>> Stashed changes:spring-ioc/src/com/hph/demo/CDPlayerTest.java
public class CDPlayerTest {


    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void cdShouldNotBeNull(){

        assertNotNull(compactDisc);;
    }

    @Test
    public void play(){

        cdPlayer.play();
    }
}
