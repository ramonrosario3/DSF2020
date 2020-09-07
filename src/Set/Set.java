package Set;

import java.io.PrintStream;

public interface Set<E> {
    public int size();
    public boolean isEmpty();
    public boolean isMember(E e);
    public boolean add(E e);
    public boolean remove(E e);
    public void clear();
    public Set<E> union(Set<E> S2);
    public Set<E> difference(Set<E> S2);
    public Set<E> intersection(Set<E> S2);
    public boolean isSubset(Set<E> S2); // checks tto see is this is subset of S2
    public Object[] toArray();
    public void print(PrintStream out);


}
