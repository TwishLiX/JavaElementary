package homework22_cache;

/**
 * @author Aleksandr Khatsaiuk
 * @version 1.0
 *
 * Interface with methods for cache implementation
 */
public interface CustomCache {
    Boolean put (String key, Object o);

    Object get (String key);

    void clear();
}
