package CacheSystem;

import Cache.Cache;
import CacheLevel.CacheLevel;
import CacheLevel.CacheLevelHandler;
import Utils.Time;

import javax.swing.*;
import java.util.Deque;
import java.util.LinkedList;

public class MultiLevelCacheSystem implements CacheSystem{

    private CacheLevelHandler level1Cache;
    private int levels;
    private Deque<Integer> readQueue;
    private Deque<Integer> writeQueue;
    private int readSum;
    private int writeSum;


    public MultiLevelCacheSystem(int levels, int[] readTimes, int[] writeTimes, int[] capacities) {
        this.levels = levels;
        CacheLevelHandler prevLevelCache = null;
        for(int i=levels-1; i>=0; i--) {
            CacheLevelHandler newLevel = new CacheLevel(readTimes[i], writeTimes[i], capacities[i]);
            newLevel.setNextLevel(prevLevelCache);
            prevLevelCache = newLevel;
        }
        level1Cache = prevLevelCache;
        readQueue = new LinkedList<>();
        writeQueue = new LinkedList<>();
        readSum  = 0;
        writeSum = 0;
    }

    @Override
    public String read(String key, Time time) {
        String value = level1Cache.read(key, time);
        if(readQueue.size() >= 10) {
            readSum -= readQueue.peek();
            readQueue.remove();
        }
        readSum += time.getTime();
        readQueue.push(time.getTime());
        return value;
    }

    @Override
    public void write(String key, String value, Time time) {
        level1Cache.write(key, value, time);
        if(writeQueue.size() >= 10) {
            writeSum -= writeQueue.peek();
            writeQueue.remove();
        }
        writeSum += time.getTime();
        writeQueue.push(time.getTime());
    }

    @Override
    public float getUsage(int level) {
        if(level > levels) return 0;
        CacheLevelHandler levelCache = level1Cache;
        while((--level) > 0) {
            levelCache = levelCache.getNextLevel();
        }
        return levelCache.getUsage();
    }

    @Override
    public float getAvgReadTime() {
        float avgTime = (float) readSum / readQueue.size();
        return avgTime;
    }

    @Override
    public float getAvgWriteTime() {
        float avgTime = (float) writeSum / writeQueue.size();
        return avgTime;
    }
}
