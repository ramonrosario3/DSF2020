package Map;

import List.List;
import List.SinglyLinkedList;


public class SinglyLinkedMap<K,V> implements Map<K,V> {

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

    private int currentSize;

    private List<MapEntry<K,V>> elements;

    public SinglyLinkedMap() {
        this.elements = new SinglyLinkedList<MapEntry<K,V>>();
    }


    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public V get(K key) {
        if(this.elements.isEmpty()) return null;
        else {
            int position = findPosition(key);
            if(position<0) return null;
            else {
                MapEntry<K,V> entry = (MapEntry<K, V>) this.elements.get(position);
                return entry.getValue();
            }
        }
    }

    private int findPosition(K key){
        int result = 0;
        for (MapEntry<K,V> e: this.elements){
            if (e.getKey().equals(key)){
                return result;
            }
            else {
                result++;
            }
        }
        return -1;
    }

    @Override
    public V put(K key, V value) {
        //erase an old key
        this.remove(key);
        V result = this.remove(key);

        MapEntry<K,V> newEntry = new MapEntry<K, V>(key, value);
        this.elements.add(newEntry, 0);
        return result;
    }

    @Override
    public V remove(K key) {
        int target =findPosition(key);
        if(target<0) return null;
        else {
//            V result = this.elements.get(target).getValue();
//            this.elements.remove(target);
//            return result;

            return this.elements.remove(target).getValue();
        }

    }

    @Override
    public boolean contains(K key) {
        return this.get(key)!=null;
    }

    @Override
    public void clear() {
        this.elements.clear();

    }

    @Override
    public List getKeys() {
        List<K> result = new SinglyLinkedList<K>();
        for (MapEntry<K,V> e: this.elements) {
            result.add(e.getKey(),0);
        }
        return result;
    }

    @Override
    public List getValues() {
        List<V> result = new SinglyLinkedList<V>();
        for (MapEntry<K,V> e: this.elements) {
            result.add(e.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, String> T = new SinglyLinkedMap<Integer, String>();
    }
}
