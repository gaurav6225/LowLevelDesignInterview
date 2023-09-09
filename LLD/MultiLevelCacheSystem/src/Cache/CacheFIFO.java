package Cache;

import java.util.LinkedHashMap;

public class CacheFIFO implements Cache{

    private LinkedHashMap<String, String> cache;
    private int capacity;

    public CacheFIFO(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public String get(String key) {
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        return null;
    }

    @Override
    public void put(String key, String value) {
        if(!cache.containsKey(key)) {
            if(cache.size() >= capacity) {
                String firstKey = cache.entrySet().iterator().next().getKey();
                cache.remove(firstKey);
            }
            cache.put(key, value);
        } else if(!cache.get(key).equals(value)) {
            cache.put(key, value);
        }
    }
}
