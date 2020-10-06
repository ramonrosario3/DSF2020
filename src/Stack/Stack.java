package Stack;

import java.io.PrintStream;

public interface Stack<E> {
    public boolean isEmpty();
    public int size();
    public E top();
    public E pop();
    public void push(E e);
    public void clear();
    public void print(PrintStream p);

}
