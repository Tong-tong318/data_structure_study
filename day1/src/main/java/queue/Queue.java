package queue;

import java.util.function.Consumer;

public class Queue implements QueueInterface{
    Node head = new Node(null, null);
    Node tail = head;
    int size;
    int capacity;
    public Queue(){
        tail.next = head;
        capacity = 1024;
    }
    public Queue(int capacity){
        tail.next = head;
        this.capacity = capacity;
    }

    @Override
    public Boolean offer(Object o) {
        if(isFull()) return false;

        Node newNode = new Node(o, head);
        tail.next = newNode;
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public Object peek() {
        return head.next.value;
    }

    @Override
    public Object pull() {
        if (isEmpty()) {
            return null;
        }
        Node geted = head.next;
        head.next = geted.next;
        if (geted == tail) {
            tail = head;
        }
        size--;
        return geted.value;
    }

    @Override
    public Boolean isEmpty() {
        return head == tail;
    }

    @Override
    public Boolean isFull() {
        return size == capacity;
    }

    public void foreach(Consumer<Object> consumer){
        Node p1 = head.next;
        while (p1.value != null){
            consumer.accept(p1.value);
            p1 = p1.next;
        }
    }

    private static class Node {
        private Object value;
        private Node next;

        private Node(){
        }
        private Node(Object value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
