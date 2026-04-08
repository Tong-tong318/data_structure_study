package linkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList {

    private Node head = new Node(888,null);

    public void add(int index, int value){
        Node prev = find(index - 1);
        Node p = new Node(value,prev.next);
        prev.next = p;
    }

    public void addLast(int value){
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = new Node(value,null);
    }

    public int delete(int index){
        Node prev = find(index - 1);
        if(prev.next == null){
            throw new NoSuchElementException();
        }
        int value = prev.next.value;
        prev.next = prev.next.next;
        return value;
    }

    public void update(int index, int value){
        Node p = find(index);
        p.value = value;
    }

    public int get(int index){
        Node p = find(index);
        return p.value;
    }

    public void forEach(Consumer<Integer> consumer){
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
        private int value;
        private Node next;

        private Node(){
        }
        private Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
