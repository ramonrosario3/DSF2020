package Stack;

import List.SinglyLinkedList;

import java.io.PrintStream;

public class SinglyLinkedStack<E> implements Stack<E> {

    private static class Node<E>{
        private E element;//Value stored in the node
        private Node<E> next;//Reference to the next node


        public Node(E element, Node next){
            this.element = element;
            this.next = next;
        }

        public Node(){
            this.element = null;
            this.next = null;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;
    private int currentSize;

    public SinglyLinkedStack(){
        this.header = new Node<E>();
        this.currentSize = 0;
    }



    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public E top() {
        return this.isEmpty() ? null : this.header.getNext().getElement();
    }

    @Override
    public E pop() {
        if(this.isEmpty()){
            return null;
        }
        else {
            Node<E> result = this.header.getNext();
            this.header.setNext(result.getNext());
            result.setNext(null);
            result.setElement(null);
            this.currentSize--;
            return result.getElement();
        }
    }

    @Override
    public void push(E e) {
        Node<E> temp = this.header.getNext();
        Node<E> newNode = new Node<E>(e,temp.getNext());
        this.header.setNext(newNode);
        temp.setNext(null);
        temp.setElement(null);

    }

    @Override
    public void clear() {
        while(this.pop()!=null);
    }

    @Override
    public void print(PrintStream p) {

    }
}
