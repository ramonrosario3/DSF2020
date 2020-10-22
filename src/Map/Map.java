package Map;

import List.List;

public interface Map<K,V> {

    public int size();
    public boolean isEmpty();
    public V get(K key);
    public V put(K key, V value);
    public V remove(K key);
    public boolean contains(K key);
    public void clear();
    public List getKeys();
    public List getValues();

}
