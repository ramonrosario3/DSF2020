package Queue;

import List.SinglyLinkedList;
import Stack.SinglyLinkedStack;

import java.io.PrintStream;

public class DoublyLinkedQueue<E> implements Queue<E> {
    private class Node<E>{
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element, Node next, Node previous){
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        public Node(){
            this.element = null;
            this.next = null;
            this.previous = null;
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

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
    }

    int currentSize;
    Node<E> header;
    Node<E> tail;

    public DoublyLinkedQueue(){
        this.header = new Node<E>();
        this.tail = new Node<E>();
        this.currentSize = 0;

        this.header.setNext(tail);
        this.tail.setPrevious(header);

    }

    @Override
    public int size(){
        return this.currentSize;
    }

    @Override
    public boolean isEmpty(){
        return this.currentSize==0;
    }

    @Override
    public E front(){
        return (this.isEmpty())? null: header.getNext().getElement();
    }

    @Override
    public void enqueue(E e) {
        Node<E> temp = this.tail.getPrevious();
        Node<E> newNode = new Node<E>();
        newNode.setElement(e);
        newNode.setNext(this.tail);
        newNode.setPrevious(temp);
        temp.setNext(newNode);
        this.tail.setPrevious(newNode);
        this.currentSize++;
    }

    @Override
    public E dequeue() {
        Node<E> out = this.tail.getPrevious();
        E result = out.getElement();

        if(this.isEmpty()) return  null;
        else {
            out.getPrevious().setNext(this.tail);
            tail.setPrevious(out.getPrevious());
            out.setElement(null);
            out.setPrevious(null);
            out.setNext(null);
            this.currentSize++;
            return result;
        }
    }

    @Override
    public void clear() {
        while (!this.isEmpty()){
            dequeue();
        }
    }

    @Override
    public void print(PrintStream P) {
        for (Node<E> temp = this.tail.getPrevious(); temp != this.header; temp = temp.getPrevious()) {
            P.println(temp.getElement());
        }
    }
}
