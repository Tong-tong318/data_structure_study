package linkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList {

    private Node head = new Node(888,null);

    public void add(Object value, int index){
        Node prev = find(index - 1);
        Node p = new Node(value,prev.next);
        prev.next = p;
    }

    public void addLast(Object value){
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = new Node(value,null);
    }

    public Object delete(int index){
        Node prev = find(index - 1);
        if(prev.next == null){
            throw new NoSuchElementException();
        }
        Object value = prev.next.value;
        prev.next = prev.next.next;
        return value;
    }

    public void update(int index, Object value){
        Node p = find(index);
        p.value = value;
    }

    public Object get(int index){
        if (isEmpty()) return null;
        Node p = find(index);
        return p.value;
    }

    public void forEach(Consumer<Object> consumer){
        Node p = head.next;
        while (p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public int getLength(){
        Node myhead = head;
        int length = 0;
        while (myhead.next != null){
            myhead = myhead.next;
            length += 1;
        }
        return length;
    }

    public boolean isEmpty(){
        return head.next == null;
    }

    private Node find(int index){
        Node p = head;
        for (int i = 0; i <= index; i++) {
            if (p.next != null) {
                p = p.next;
            }else {
                throw new NoSuchElementException();
            }
        }
        return p;
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
