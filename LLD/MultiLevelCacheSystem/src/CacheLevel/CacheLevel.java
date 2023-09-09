package CacheLevel;

import Cache.CacheFIFO;
import Utils.Time;

public class CacheLevel extends CacheLevelHandler{

    public CacheLevel(int readTime, int writeTime,int capacity) {
        this.readTime = readTime;
        this.writeTime = writeTime;
        this.cache = new CacheFIFO(capacity);
    }

    @Override
    public String read(String key, Time time) {
        time.incrementTime(this.readTime);
        String getValue = cache.get(key);
        if(getValue != null)
            return getValue;
        String value = super.read(key, time);
        if(value != null) {
            time.incrementTime(this.writeTime);
            cache.put(key, value);
            return value;
        }
        return null;
    }

    @Override
    public void write(String key, String value, Time time) {
        time.incrementTime(this.writeTime);
        cache.put(key, value);
        super.write(key, value, time);
    }

    @Override
    public float getUsage() {
        return cache.usage();
    }
}
