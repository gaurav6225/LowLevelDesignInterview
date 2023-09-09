package CacheSystem;

import Cache.Cache;
import CacheLevel.CacheLevel;
import CacheLevel.CacheLevelHandler;
import Utils.Time;

public class MultiLevelCacheSystem implements CacheSystem{

    private CacheLevelHandler level1Cache;

    public MultiLevelCacheSystem(int levels, int[] readTimes, int[] writeTimes, int[] capacities) {
        CacheLevelHandler prevLevelCache = null;
        for(int i=levels-1; i>=0; i--) {
            CacheLevelHandler newLevel = new CacheLevel(readTimes[i], writeTimes[i], capacities[i]);
            newLevel.setNextLevel(prevLevelCache);
            prevLevelCache = newLevel;
        }
        level1Cache = prevLevelCache;
    }

    @Override
    public String read(String key, Time time) {
        return level1Cache.read(key, time);
    }

    @Override
    public void write(String key, String value, Time time) {
        level1Cache.write(key, value, time);
    }
}
