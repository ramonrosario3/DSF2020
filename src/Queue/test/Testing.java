package Queue.test;

import Queue.DoublyLinkedQueue;
import Queue.Queue;

public class Testing {
    public static void main(String[] args) {
        Queue<String> Q1 = new DoublyLinkedQueue<String>();

        Q1.enqueue("Bob");
        Q1.enqueue("Tim");
        Q1.enqueue("Jane");

        Q1.print(System.out);
        System.out.println();

        Q1.dequeue();
        Q1.print(System.out);
    }
}
