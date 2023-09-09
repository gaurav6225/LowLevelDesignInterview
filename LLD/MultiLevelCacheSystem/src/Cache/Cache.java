package Cache;

public interface Cache {
    public String get(String key);
    public void put(String key, String value);
    public float usage();
}
