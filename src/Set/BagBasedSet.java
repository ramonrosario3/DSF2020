package Set;

import Bag.BagGenerics.DynamicBag;
import Bag.BagGenerics.Bag;

import java.io.PrintStream;

public class BagBasedSet<E> implements Set<E>{
    private Bag<E> elements;

    public BagBasedSet(){
        this.elements = new DynamicBag<E>();
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
    public boolean isMember(E e) {
        return this.elements.isMember(e);
    }

    @Override
    public boolean add(E e) {
        if(!this.elements.isMember(e)) {
            this.elements.add(e);
            return true;
        }
        return  false;
    }

    @Override
    public boolean remove(E e) {
        return this.elements.remove(e);
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public Object[] toArray() {
        return this.elements.toArray();
    }

    @Override
    public boolean isSubset(Set<E> S2) {
        return this.intersection(S2).isEmpty();
    }

    @Override
    public Set<E> intersection(Set<E> S2) {
        return S2.difference(this.difference(S2));
    }

    @Override
    public Set<E> difference(Set<E> S2) {
        Set<E> result = new BagBasedSet<E>();
        E[] temp1 = (E[])this.elements.toArray();
        for (int i = 0; i < this.size(); i++) {
            if(!S2.isMember(temp1[i])){
                result.add(temp1[i]);
            }
        }
        return result;
    }

    @Override
    public Set<E> union(Set<E> S2) {
        Set<E> result = new BagBasedSet<E>();
        E[] temp1 = (E[])this.elements.toArray();
        E[] temp2 = (E[])this.toArray();
        for (int i = 0; i < this.size(); i++) {
            result.add(temp1[i]);
        }
        for (int i = 0; i < S2.size(); i++) {
            result.add(temp2[i]);
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
