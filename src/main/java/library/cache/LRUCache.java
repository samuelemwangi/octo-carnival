package library.cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<K, V> {

    private int size;
    private final HashMap<K, V> cache;

    private final LinkedList<K> keysTracker;

    public LRUCache() {
        this(5);
    }

    public LRUCache(int size) {
        this.size = size;
        cache = new HashMap<>(size);
        keysTracker = new LinkedList<>();
    }

    public void set(K key, V value) {
        if (cache.containsKey(key)) {
            cache.replace(key, value);
            return;
        }

        if (cache.size() == this.size) {
            K leastAccessedKey = null;
            if(keysTracker.size() > 0)
                leastAccessedKey = keysTracker.getFirst();
            evictIfNeeded(leastAccessedKey);
        }

        cache.put(key, value);

    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            K latestAccessed = null;
            if (keysTracker.size() > 0)
                latestAccessed = keysTracker.getLast();
            if (keysTracker.size() > 0 && !latestAccessed.equals(key))
                keysTracker.addLast(key);
            return cache.get(key);
        }
        return null;
    }

    private void evictIfNeeded(K key) {
        if(key == null)
            return;

        cache.remove(key);

        for (int i = 0; i < keysTracker.size(); i++)
            if (keysTracker.get(i).equals(key))
                keysTracker.remove(i);
    }
}
