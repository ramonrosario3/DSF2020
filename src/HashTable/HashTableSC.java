package HashTable;

import List.SinglyLinkedList;
import List.List;
import Map.Map;

public class HashTableSC<K,V> implements Map<K,V> {

    public static class MapEntry<K,V>{
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Object[] buckets;
    private int currentSize;
    private static final int DEFAULT_SIZE = 10;

    public HashTableSC(int numBuckets){
        if(numBuckets<1) throw new IllegalStateException("Number of buckets must be at least 1");

        this.currentSize = 0;
        this.buckets = new Object[numBuckets];

        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i]  = new SinglyLinkedList<MapEntry<K,V>>();
        }

    }

    public HashTableSC(){
        this(DEFAULT_SIZE);
    }

    private int hashFunction(K key){
        return key.hashCode() % this.buckets.length;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.size()==0;
    }

    @Override
    public V get(K key) {
        int bucketNumber = this.hashFunction(key);
        List<MapEntry<K,V>> bucket = (List<MapEntry<K,V>>) this.buckets[bucketNumber];
        for (MapEntry<K,V> e: bucket){
            if(e.getKey().equals(key)){
                return e.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V result = remove(key);
        int bucketNumber = this.hashFunction(key);
        List<MapEntry<K,V>> bucket = (List<MapEntry<K,V>>) this.buckets[bucketNumber];
        bucket.add(new MapEntry<>(key, value),0);
        this.currentSize++;
        return result;
    }

    @Override
    public V remove(K key) {
        int bucketNumber =  this.hashFunction(key);
        List<MapEntry<K,V>> bucket = (List<MapEntry<K,V>>) this.buckets[bucketNumber];
        for (MapEntry<K,V> e: bucket) {
            if(e.getKey().equals(key))  return e.getValue();
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public List getKeys() {
        return null;
    }

    @Override
    public List getValues() {
        return null;
    }
}
