package queue;

import java.util.function.Consumer;

/**
 * 基础队列
 * 基于 单向链表带哨兵 实现
 */
public class LinkedQueue<E> implements QueueInterface<E>{
    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;
    int size;
    int capacity;
    public LinkedQueue(){
        tail.next = head;
        capacity = 1024;
    }
    public LinkedQueue(int capacity){
        tail.next = head;
        this.capacity = capacity;
    }

    @Override
    public Boolean offer(E o) {
        if(isFull()) return false;

        tail.next = new Node<>(o, head);
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public E peek() {
        return head.next.value;
    }

    @Override
    public E pull() {
        if (isEmpty()) {
            return null;
        }
        Node<E> geted = head.next;
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
        Node<E> p1 = head.next;
        while (p1.value != null){
            consumer.accept(p1.value);
            p1 = p1.next;
        }
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;

        private Node(){
        }
        private Node(E value, Node<E> next){
            this.value = value;
            this.next = next;
        }
    }
}
