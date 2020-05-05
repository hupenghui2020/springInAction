package com.hph.config;

import com.hph.demo.BlankDisc;
import com.hph.demo.CompactDisc;
import com.hph.demo.TrackCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author com.hph
 */
@Configuration
@ComponentScan(basePackages = "com.com.hph.demo")
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc blankDisc(){
        List<String> list = new ArrayList<>();
        list.add("Sgt. Pepper's Lonely Hearts Club Band");
        list.add("With a Little Help from My Friends");
        list.add("Lucy in the Sky with Diamonds");
        list.add("Getting Better");
        list.add("Fixing a Hole");
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setArtist("The Beatles");
        blankDisc.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        blankDisc.setTracks(list);
        return blankDisc;
    }

    @Bean
    public TrackCounter trackCounter(){

        return new TrackCounter();
    }
}
