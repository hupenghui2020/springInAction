package com.hph.demo;

import org.springframework.stereotype.Component;

/**
 * 自动装配
 * @author 10499
 */

@Component
public class SgtPeppers implements CompactDisc {

    @Override
    public void play() {

        String title = "Sgt. Peppers's Lonely Hearts Club Band";
        String artist = "The Beatles";
        System.out.println("Playing " + title + " by " + artist);
    }
}
