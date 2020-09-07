package Bag.BagGenerics;

public class DynamicBag<E> implements Bag<E> {
    private E[] elements;
    private int currentSize;

    private static final int DEFAULT_SIZE = 10;

    public DynamicBag(int initialSize){
        if(initialSize<1){
            throw new IllegalArgumentException("Initial size cannot be smaller than 1");
        }
        this.currentSize = 0;
        this.elements =(E[]) new Object[initialSize];
    }
    public  DynamicBag(){
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
        for (int i = 0; i < this.size(); i++) {
            if(this.elements[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.elements[i]=null;
            this.currentSize=0;
        }

    }

    @Override
    public void add(E e) {
        if(e==null){
            throw new IllegalArgumentException("Argument to ad cannot be null");
        }
        if(this.size()==this.elements.length){
            this.reAllocate();
        }
        this.elements[this.currentSize++]=e;

    }
    public void reAllocate(){
        E[] newElements = (E[]) new Object[this.size()*2];
        for (int i = 0; i < this.size(); i++) {
            newElements[i] = this.elements[i];
        }
        this.elements=newElements;
    }

    @Override
    public int count(E e) {
        int result = 0;
        for (int i = 0; i < this.size(); i++) {
            if(this.elements[i].equals(e)){
                result++;
            }
        }
        return result;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < this.size(); i++) {
            if(this.elements[i].equals(e)){
                this.elements[i] = this.elements[this.size()-1];
                this.elements[this.currentSize-1]=null;
                this.currentSize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(E e) {
        int result = 0;
        while (this.remove(e)){
            result++;
        }
        return result;
    }

    @Override
    public Object[] toArray() {
        Object result[] = new Object[this.size()];
        for (int i = 0; i <this.size() ; i++) {
            result[i]=this.elements[i];
        }
        return result;
    }
}
