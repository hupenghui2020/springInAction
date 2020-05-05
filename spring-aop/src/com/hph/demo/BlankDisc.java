package com.hph.demo;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @author com.hph
 */
public class BlankDisc implements CompactDisc{

    private String title;

    private String artist;

    private List<String> tracks;

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for(String track : tracks){
            System.out.println("-Track: " + track);
        }
    }

    @Override
    public void playTrack(int trackNumber) {

        System.out.println("playing 歌曲" + trackNumber + ": " + tracks.get(trackNumber));
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
