package BinarySearchTree;

import Map.Map;
import List.List;
import List.SinglyLinkedList;

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
        if(this.size()==0){
            MapEntry<K,V> M =  new MapEntry<K, V>(key, value);
            this.root =  new BinaryTreeNodeImp<MapEntry<K, V>>(M, null,null, null);
            this.currentSize++;
            return null;
        }
        else{
            return this.putAux(key, value, this.root);
        }
    }

    private V putAux(K key, V value, BinaryTreeNode <MapEntry<K,V>> N){
        int comparison =  this.keyComparator.compare(key,N.getValue().getKey());
        if(comparison<0){
            //va para la izquierda
            if(N.getLeftChild() == null){
                //insert new node. base case 1
                MapEntry<K,V> M =  new MapEntry<K, V>(key, value);
                BinaryTreeNodeImp<MapEntry<K,V>> newNode =
                        new BinaryTreeNodeImp<MapEntry<K, V>>(M,N, null,null);
                N.setLeftChild(newNode);
                this.currentSize++;
                return null;

            }
            else {
                return this.putAux(key, value, N.getLeftChild());//recursion on the left
            }
        }
        else{
            //va para la derecha
            if(N.getRightChild()==null){
                //insert new node. base case 2
                MapEntry<K,V> M =  new MapEntry<K, V>(key, value);
                BinaryTreeNodeImp<MapEntry<K,V>> newNode =
                        new BinaryTreeNodeImp<MapEntry<K, V>>(M,N, null,null);
                N.setRightChild(newNode);
                this.currentSize++;
                return null;

            }
            else{
                return this.putAux(key, value, N.getRightChild());

            }

        }
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
        return this.get(key)!=null;
    }

    @Override
    public void clear() {
        while (this.size()!=0){
            remove(this.root.getValue().getKey());
        }

    }

    @Override
    public List<K> getKeys() {
        List<K> L = new SinglyLinkedList<K>();
        if (this.isEmpty()) {
            return L;
        } else {
            this.getKeyAux(this.root, L);
            return L;
        }
    }

    private void getKeyAux(BinaryTreeNode<MapEntry<K,V>> N, List<K> L) {
        if (N == null){
            return;
        }
        else if(N.getLeftChild()==null && N.getRightChild()==null){
            L.add(N.getValue().getKey());
            return;
        }
        else {
            this.getKeyAux(N.getLeftChild(),L);
            L.add(N.getValue().getKey());
            this.getKeyAux(N.getRightChild(),L);
            return;
        }

    }

    @Override
    public List<V> getValues() {
        return null;
    }

}
