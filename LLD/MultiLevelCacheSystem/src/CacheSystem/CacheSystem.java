package CacheSystem;

import Utils.Time;

public interface CacheSystem {
    public String read(String key, Time time);
    public void write(String key, String value, Time time);
    public float getUsage(int level);
    public float getAvgReadTime();
    public float getAvgWriteTime();
}
