package per.jaceding.algorithm.classic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LruCache
 *
 * @author jaceding
 * @date 2020/9/27
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private static int MAX_ENTRIES;

    public LruCache(int capacity) {
        super(capacity, 0.75f, true);
        MAX_ENTRIES = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
