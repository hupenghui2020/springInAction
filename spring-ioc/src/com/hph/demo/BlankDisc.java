package com.hph.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author com.hph
 */
public class BlankDisc implements CompactDisc{

    /**
     * 占位符
     */
    @Value("#{systemProperties['title']}")
    private String title;

    @Value("#{systemProperties['artist']}")
    private String artist;

    private List<String> tracks;

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for(String track : tracks){
            System.out.println("-Track: " + track);
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
