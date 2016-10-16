package ex4;

import java.util.*;

/**
 * Created by Jadwiga on 2016-10-15.
 */
public class BiMapImpl<K,V> extends TreeMap<K,V> implements BiMap<K,V>  {

    public BiMapImpl() {
    }

    @Override
    public V forcePut(K key, V value) {
        while(super.containsValue(value)) {
            super.values().remove(value);
        }
        super.put(key,value);
        return value;
    }

    @Override
    public BiMap<V,K> inverse() {
        BiMap<V, K> inverseMap = new BiMapImpl<V,K>();
        for (K key: super.keySet()){
            inverseMap.put(super.get(key), key);
        }
        return inverseMap;
    }

    @Override
    public V put(K key, V value){
        if (super.containsValue(value)){
            throw new IllegalArgumentException("You cannot put the value which is already in BiMap");
        } else
            return super.put(key,value);
    }

}
