package homework22_cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Aleksandr Khatsaiuk
 * @version 1.0
 *
 * Class with LRUMap data structure implementation
 *
 * @param <K> - key data type
 * @param <V> - value data type
 */
public class LRUMap<K, V> {
    private final HashMap<K, V> hashMap;
    private final LinkedList<V> linkedList;
    private final int size;
    private int count;

    /**
     * Constructor for declaration a LRUMap instance
     *
     * @param size - size of LRUMap
     */
    public LRUMap(int size) {
        hashMap = new HashMap<>();
        linkedList = new LinkedList<>();
        this.size = size;
        count = 0;
    }

    /**
     * Put a value to LRUMap
     *
     * @param key - key to the value
     * @param value - value
     */
    public void put(K key, V value) {
        if (count == size) {
            hashMap.remove(hashMap.keySet().toArray()[0]);
            linkedList.removeFirst();
            count--;
        }
        if (!linkedList.contains(value)) {
            linkedList.add(value);
            hashMap.put(key, value);
        } else {
            linkedList.remove(value);
            linkedList.addLast(value);
        }
        count++;
    }

    /**
     * Get a value from LRUMap
     *
     * @param key - key to the value
     * @return {@link HashMap} value or null in case there is no such value.
     */
    public V get(V key) {
        if (hashMap.containsKey(key)) {
            linkedList.remove(hashMap.get(key));
            linkedList.addLast(hashMap.get(key));
            return hashMap.get(key);
        }
        return null;
    }

    /**
     * Clear LRUMap
     */
    public void clear() {
        hashMap.clear();
        linkedList.clear();
        count = 0;
    }

    /**
     * Get all values from {@link HashMap}
     *
     * @return {@link Collection} of {@link Cache} values
     */
    public Collection<V> values() {
        return hashMap.values();
    }

}
