package Set;

import java.io.PrintStream;

public class ArraySet<E> implements Set<E> {
    private E[] elements;
    private int currentsize;
    private static final int DEFAULT_SIZE = 10;

    public ArraySet(int initialSize){
        if(initialSize<1){
            throw new IllegalArgumentException("Size must be at least 1");
        }
        this.currentsize = 0;
        this.elements = (E[]) new Object[initialSize];
    }
    public ArraySet(){
        this(DEFAULT_SIZE);
    }


    @Override
    public int size() {
        return this.currentsize;
    }

    @Override
    public boolean isEmpty() {
        return this.currentsize==0;
    }

    @Override
    public boolean isMember(E e) {
        for (int i = 0; i < this.size(); i++) {
            if (this.elements[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        if(e==null){
            throw new IllegalArgumentException("Argument cannot be null");
        }
        else {
            if (this.isMember(e)) {
                return false;
            }
            //checks for space
            if (this.size() == this.elements.length) {
                this.reAllocate();
            }
            //add
            this.elements[this.currentsize++] = e;
            return true;
        }
    }
    private void reAllocate(){
        E[] newElements = (E[]) new Object[this.size()*2];
        for (int i = 0; i < this.size(); i++) {
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
        return;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < this.size(); i++) {
            if(this.elements[i].equals(e)){
                this.elements[i] = this.elements[this.size()-1];
                this.elements[this.currentsize-1] = null;
                this.currentsize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.elements[i]=null;
        }
        this.currentsize = 0;
    }

    @Override
    public Object[] toArray() {
        if(this.size()==0){
            return null;
        }
        else {
            Object[] result = new Object[this.size()];
            for (int i = 0; i < this.size(); i++) {
                result[i] = this.elements[i];
            }
            return result;
        }
    }

    @Override
    public boolean isSubset(Set<E> S2) {
        return this.difference(S2).isEmpty();
    }

    @Override
    public Set<E> intersection(Set<E> S2) {
        return this.difference(S2.difference(this));
    }

    @Override
    public Set<E> difference(Set<E> S2) {
        Set<E> result = new ArraySet<E>();
        for (int i = 0; i < this.size(); i++) {
            if(!S2.isMember(this.elements[i])){
                result.add(this.elements[i]);
            }
        }
        return result;
    }

    @Override
    public Set<E> union(Set<E> S2) {
        Set<E> result = new ArraySet<E>(this.size()+S2.size());
        for (int i = 0; i < this.size(); i++) {
            result.add(this.elements[i]);
        }
        E[] temp =(E[]) S2.toArray();
        for (int i = 0; i < this.size(); i++) {
            result.add(temp[i]);
        }
        return result;
    }

    @Override
    public void print(PrintStream out){
        Object[] temp = this.toArray();
        for (int i = 0; i < this.size(); i++) {
            out.print(temp[i]);
            out.print(" ");
        }
        out.print("");

    }
}
