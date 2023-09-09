package CacheSystem;

import Utils.Time;

public interface CacheSystem {
    public String read(String key, Time time);
    public void write(String key, String value, Time time);
}
