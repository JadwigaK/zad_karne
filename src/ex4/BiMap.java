package ex4;

/**
 * Created by Jadwiga on 2016-10-15.
 */

import java.util.Map;

/**
 * A bimap (or "bidirectional map") is a map that preserves the uniqueness of its values as well as that of its keys.
 * This constraint enables bimaps to support an "inverse view", which is another bimap containing the same entries as
 * this bimap but with reversed keys and values.
 */
public interface BiMap<K,V> extends Map<K,V> {

    /**
     * An alternate form of put that silently removes any existing entry with the value value before proceeding
     * with the put(K, V) operation.
     *
     */
    V forcePut(K key, V value);

    /**
     * Returns the inverse view of this bimap, which maps each of this bimap's values to its associated key.
     */
    BiMap<V,K> inverse();

    /**
     * Throws IllegalArgumentException - if the given value is already bound to a different key in this bimap.
     * The bimap will remain unmodified in this event. To avoid this exception, call forcePut(K, V) instead.
     */
    @Override
    V put(K key, V value);
}
