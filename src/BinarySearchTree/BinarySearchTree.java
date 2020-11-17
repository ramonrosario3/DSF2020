package BinarySearchTree;

import Map.Map;
import List.List;

import java.util.Comparator;

public class BinarySearchTree<K,V> implements Map<K,V> {

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
    private BinaryTreeNode<MapEntry<K,V>> root;
    private Comparator<K> keyComparator;

    public BinarySearchTree(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
        this.root = null;
        this.currentSize = 0;
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
        return this.getAux(key, this.root);
    }

    private V getAux(K key, BinaryTreeNode<MapEntry<K,V>> N){
        if(N == null) return null;
        else{
            int comparison =  this.keyComparator.compare(key,N.getValue().getKey());
            if(comparison==0) return N.getValue().getValue();
            else if (comparison<0) return this.getAux(key, N.getLeftChild());//if key < node.key
            else return this.getAux(key, N.getRightChild());//if key >= node.key
        }
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return this.remAux(key, this.root);
    }
    private V remAux(K key, BinaryTreeNode<MapEntry<K,V>> N){
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
