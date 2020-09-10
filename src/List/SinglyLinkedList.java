package List;

import java.awt.event.ItemEvent;
import java.io.PrintStream;
import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {
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
    //Private fields of SinglyLinkedList
    private int currentSize;
    private Node<E> header;

    public SinglyLinkedList() {
        this.currentSize = 0;
        this.header = new Node<E>();

    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public boolean isMember(E e) {
        return firstIndex(e)>=0;
    }

    @Override
    public int firstIndex(E e) {
//        int position =0;
//        Node<E> temp = header.getNext();
//        while (temp!=null){
//            if(temp.getElement().equals(e)) {
//                return position;
//            }
//            position++;
//            temp = temp.getNext();
//        }
//
//        return -1;
        int position = 0;
        for (Node<E> temp = this.header.getNext(); temp.getNext()!=null; temp = temp.getNext(), position++) {
            if(temp.getElement().equals(e)){
                return position;
            }
        }
        return -1;
    }

    @Override
    public int lastIndex(E e) {
        int position = -1, counter = 0;
        for (Node<E> temp = this.header.getNext(); temp.getNext()!=null; temp = temp.getNext(), counter++) {
            if(temp.getElement().equals(e)){
                position = counter;
            }
        }
        return position;
    }

    @Override
    public void add(E e) {

    }

    @Override
    public void add(E e, int index) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public int removeAll(E e) {
        return 0;
    }

    @Override
    public E replace(int inddex, E e) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void print(PrintStream out) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
