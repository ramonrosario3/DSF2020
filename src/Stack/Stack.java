package Stack;

import java.io.PrintStream;

public interface Stack<E> {
    public boolean isEmpty();
    public E top();
    public E pop();
    public void push();
    public void clear();
    public void print(PrintStream p);

}
