package homework22_cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Aleksandr Khatsaiuk
 * @version 1.0
 *
 * Class with cache functional implementation
 */
public class Cache implements CustomCache {
    private static final Logger logger = LoggerFactory.getLogger(Cache.class);
    private final LRUMap<String, Object> objects;
    private final int lifeTime;

    /**
     * Constructor for creating a cache instance
     *
     * @param lifeTime - cache lifetime
     * @param maxItems - cache capacity
     */
    public Cache(int lifeTime, int maxItems) {
        this.lifeTime = lifeTime * 1000;
        objects = new LRUMap<>(maxItems);
        logger.info("New cache has been created.");
        clear();
    }

    /**
     * Print all values from the cache
     */
    public void printAllValues() {
        System.out.println(objects.values());
        logger.info("All values from the cache have been printed.");
    }

    /**
     * Put a value to the cache
     *
     * @param key - key to the value
     * @param obj - value
     * @return {@link Boolean}
     */
    @Override
    public Boolean put(String key, Object obj) {
        objects.put(key, obj);
        logger.info("Element with values <{}, {}> has been added to the cache.", key, obj);
        return true;
    }

    /**
     * Get a value from the cache
     *
     * @param key - key to the value
     * @return {@link Object} from the {@link Cache}
     */
    @Override
    public Object get(String key) {
        Object obj = objects.get(key);
        if (obj != null) logger.info("Element with a key {} has been got from the cache.", key);
        else logger.info("Element with a key {} hasn't been found among the cache elements.", key);
        return obj;
    }

    /**
     * Clear the cache
     */
    @Override
    public synchronized void clear() {
        new Thread(() -> {
            try {
                Thread.sleep(lifeTime);
            } catch (InterruptedException ignored) {
            }
            objects.clear();
            logger.info("The cache has been cleared.");
        }).start();
    }
}
