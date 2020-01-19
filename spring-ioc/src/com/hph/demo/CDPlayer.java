package com.hph.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hph
 */
@Component
public class CDPlayer implements MediaPalyer{

    @Autowired
    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {

        compactDisc.play();
    }

    /*public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }*/
}
