package List;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    public class ArrayListIterator<E> implements Iterator<E>{
        private int currentPosition;

        public ArrayListIterator(){
            this.currentPosition =0;
        }

        @Override
        public boolean hasNext() {
            return this.currentPosition<currentSize;
        }

        @Override
        public E next() {
            if(this.hasNext()){
                E result = (E) elements[this.currentPosition++];
                return result;
            }else throw new NoSuchElementException();
        }
    }
    private E[] elements;
    private int currentSize;
    private static final int DEFAULT_SIZE = 10;

    public ArrayList(int initialSize){
        if(this.currentSize<1){
            throw new IllegalArgumentException("Size cannot be smaler tha 1");
        }
        this.currentSize = 0;
        this.elements = (E[]) new Object[initialSize];
    }
    public ArrayList(){
        this(DEFAULT_SIZE);
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
    public boolean isMember(E e) {
        return this.firstIndex(e)>=0;
    }

    @Override
    public int firstIndex(E e) {
        for (int i = 0; i<this.size(); i++){
            if(this.elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndex(E e) {
        for (int i = this.size(); i>0; i--){
            if(this.elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(E e) {

    }

    @Override
    public void add(E e, int index) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public int removeAll(E e) {
        return 0;
    }

    @Override
    public E replace(E e) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            result[i] = this.elements[i];
        }
        return result;
    }

    @Override
    public void print(PrintStream out) {

    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<E>();
    }
}