package doublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList(){
        Node head = new Node();
        Node tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void add(int index, int value){
        Node prev = find(index - 1);
        Node next = prev.next;
        Node thiz = new Node(prev, value, next);

        thiz.prev = prev;
        thiz.next = next;
        prev.next = thiz;
        next.prev = thiz;
    }

    private Node find(int index){
        Node p = head;
        for (int i = 0; i <= index; i++) {
            if (p.next != null)  p = p.next;
            else throw new NoSuchElementException();
        }
        return p;
    }

    private static class Node{
        private Node prev;
        private Node next;
        private int value;

        private Node(){
        }

        private Node(Node prev, int value, Node next){
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
