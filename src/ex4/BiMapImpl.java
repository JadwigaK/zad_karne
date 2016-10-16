package ex4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Jadwiga on 2016-10-15.
 */
public class BiMapImpl<K,V> implements BiMap<K,V> {
    private Map<K,V> map = new TreeMap<K, V>();
    private Map<V,K> mapInversed = new TreeMap<V, K>();


    public BiMapImpl() {
    }

    private BiMapImpl(Map<K, V> mapA, Map<V, K> mapB) {
        this.map=mapA;
        this.mapInversed =mapB;
    }

    @Override
    public V forcePut(K key, V value) {
        map.put(key,value);
        mapInversed.put(value,key);
        return value;
    }

    @Override
    public BiMap<V,K> inverse() {
        return new BiMapImpl<V, K>(mapInversed, map);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsKey(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value){
        if (map.containsValue(value)){
            throw new IllegalArgumentException("You cannot put the value which is already in BiMap");
        } else
            map.put(key,value);
            mapInversed.put(value,key);
            return value;
    }

    @Override
    public V remove(Object key) {
        V value = map.remove(key);
        mapInversed.remove(value);
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V>map) {
        for (K k: map.keySet()) {
            this.map.put(k, map.get(k));
        }
    }

    @Override
    public void clear() {
        map.clear();
        mapInversed.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }

}
