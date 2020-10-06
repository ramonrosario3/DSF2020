package Stack;

import java.io.PrintStream;

public class ArrayStack<E> implements Stack<E> {

    private E[] elements;
    private int top;
    private static final int DEFAULT_SIZE =10;

    public ArrayStack(int initialsize){
        if(initialsize<1){
            throw new IllegalArgumentException("Initial size must be at least size");
        }
        this.elements =  (E[]) new Object[initialsize];
        this.top = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.top == 0;
    }

    @Override
    public int size() {
        return this.top;
    }

    @Override
    public E top() { // O(1)
        return this.isEmpty() ? null : this.elements[this.size()-1];
    }

    @Override
    public E pop() { //O(1)
        if(this.isEmpty()){
            return null;
        }
        else {
            E result = this.top();
            this.elements[this.top-1] = null;
            this.top--;
            return result;
        }
    }

    @Override
    public void push(E e) { //O(n), in case of reAllocate()
        if(this.size()==this.elements.length){
            this.reAllocate();
        }
        this.elements[this.size()] = e;
        this.top++;

    }
    private void reAllocate(){
        E[] newElements =(E[]) new Object[this.size()*2];
        for (int i = 0; i < this.size(); i++) {
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public void clear() { //O(n), n = this.size();
        while(this.pop()!=null);
    }

    @Override
    public void print(PrintStream p) {
        for (int i = this.size()-1; i <= 0; i--) {
            p.println(this.elements[i]);
        }

    }
}
