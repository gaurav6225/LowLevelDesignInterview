package CacheLevel;

import Cache.Cache;
import Utils.Time;

public abstract class CacheLevelHandler {
    private CacheLevelHandler nextLevel;
    public int readTime;
    public int writeTime;
    public Cache cache;

    public CacheLevelHandler setNextLevel(CacheLevelHandler nextLevel) {
        this.nextLevel = nextLevel;
        return this;
    }

    public CacheLevelHandler getNextLevel() {
        return nextLevel;
    }

    public String read(String key, Time time) {
        if(nextLevel != null) {
            return nextLevel.read(key, time);
        }
        return null;
    }

    public void write(String key, String value, Time time) {
        if(nextLevel != null) {
            nextLevel.write(key, value, time);
        }
        return;
    }

    public abstract float getUsage();
}
