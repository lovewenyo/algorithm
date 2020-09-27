package pers.dingjie.leetcode;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jaceding
 * @date 2020/9/27
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private static int MAX_ENTRIES;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        MAX_ENTRIES = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
