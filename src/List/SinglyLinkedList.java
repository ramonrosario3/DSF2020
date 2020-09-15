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
        if(this.isEmpty()){
            Node<E> newNode = new Node<E>();
            newNode.setElement(e);
            this.header.setNext(newNode);
            this.currentSize++;
        }
        else{
            //Cool
            //for (Node<E> temp = this.header.getNext(); temp.getNext()!=null; temp = temp.getNext();
            Node<E> temp = header.getNext();
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            Node<E> newNode = new Node<E>();
            newNode.setElement(e);
            temp.setNext(newNode);
            this.currentSize++;//
        }

    }

    @Override
    public void add(E e, int index) {
        if((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        else if(index == this.size()){
            this.add(e);
        }
        else{
            //what if index is 0
            Node<E> temp = null;
            if(index == 0){
                temp = this.header;
            }
            else{
                temp = this.getPosition(index -1);
            }
            Node<E> newNode = new Node<E>();
            newNode.setElement(e);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            this.currentSize++;
        }


    }
    private Node<E> getPosition(int index){
        //assume the index is valid
        int currentPosition = 0;
        Node<E> temp = this.header.getNext();
        while (currentPosition < index ){
            temp =temp.getNext();
            currentPosition++;
        }
        //temp points to node a t position index
        return temp;//return reference the Node

    }

    @Override
    public E get(int index) {
        if((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node<E> target = this.getPosition(index);
        return target.getElement();
    }

    @Override
    public E remove(int index) {
        if((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node<E> target = this.getPosition(index-1);
        E result  = target.getNext().getElement();
        target.setNext(target.getNext().getNext());
        return result;
    }

    @Override
    public boolean remove(E e) {
        if(this.isMember(e)){
            this.remove(this.firstIndex(e));
            return true;
        }
        return false;
    }

    @Override
    public int removeAll(E e) {
        int count = 0;
        while (this.remove(e)){
            count++;
        }
        return count;
    }

    @Override
    public E replace(int index, E e) {
        if((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node<E> target = this.getPosition(index);
        E result = target.getElement();
        target.setElement(e);
        return result;
    }

    @Override
    public void clear() {
        while(!this.isEmpty()){
            this.remove(0);
        }

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
