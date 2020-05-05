package com.hph.demo;

/**
 * @author com.hph
 * 光碟
 */
public interface CompactDisc {

    /**
     * 播放
     */
    void play();

    /**
     * 播放指定的歌曲
     * @param trackNumber
     */
    void playTrack(int trackNumber);
}
