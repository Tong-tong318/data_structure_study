package doublyLinkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    Node head = new Node();
    Node tail = new Node();

    public DoublyLinkedList(){
        head.next = tail;
        tail.prev = head;
    }

    public void add(int index, int value){
        Node prev = find(index - 1);
        Node next = prev.next;
        Node thiz = new Node(prev, value, next);

        prev.next = thiz;
        next.prev = thiz;
    }

    public void addLast(int value){
        Node prev = tail.prev;
        Node thiz = new Node(prev, value, tail);
        prev.next = thiz;
        tail.prev = thiz;
    }

    public void addFirst(int value){
        add(0,value);
    }

    public int delete(int index){
        Node thiz = find(index);
        thiz.prev.next = thiz.next;
        thiz.next.prev = thiz.prev;
        return thiz.value;
    }

    public void update(int index, int value){
        Node thiz = find(index);
        thiz.value = value;
    }

    public void ForEach(Consumer<Integer> consumer){
        Node thiz = head.next;
        while (thiz != tail){
            consumer.accept(thiz.value);
            thiz = thiz.next;
        }
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
