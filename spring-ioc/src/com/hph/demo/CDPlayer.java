package com.hph.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPalyer{

    @Autowired
    private CompactDisc compactDisc;

    @Override
    public void play() {

        compactDisc.play();
    }
}
