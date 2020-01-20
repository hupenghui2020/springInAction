package com.hph.demo;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * 切面，计算次数
 * @author hph
 */
// @Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    /*@Pointcut("execution(* com.hph.demo.CompactDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber){}*/

    // @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber){
        int currentCount = getPlayCount(trackNumber);
        System.out.println("当前的歌曲已经播放了：" + currentCount + "次！！！");
        trackCounts.put(trackNumber, ++currentCount);
    }

    // @AfterReturning("trackPlayed(trackNumber)")
    public void playedCount(int trackNumber){

        System.out.println("您刚刚又播放了一次，现在是" + trackCounts.get(trackNumber) + "次了");
    }

    private int getPlayCount(int trackNumber) {

        return trackCounts.containsKey(trackNumber)
                ? trackCounts.get(trackNumber) : 0;
    }
}
