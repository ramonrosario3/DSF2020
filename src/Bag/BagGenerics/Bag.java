package Bag.BagGenerics;

public interface Bag<E> {
    public int size();
    public boolean isEmpty();
    public boolean isMember(E e);
    public void clear();
    public void add(E e);
    public int count(E e);
    public boolean remove(E e);
    public int removeAll(E e);
    public Object[] toArray();

}
