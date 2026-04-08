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











    private static Node deleteAllSuchElement1(Node head, int target){
        Node p1 = head;
        Node p2 = head.next;

        while (p2 != null){
            if (p2.value == target){
                p1.next = p2.next;
            }else {
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        return head;
    }

    private static Node deleteAllSuchElement2(Node node, int target){
        if (node == null){
            return null;
        }
        Node next = deleteAllSuchElement2(node.next, target);
        if (node.value == target){
            return next;
        }
        node.next = next;
        return node;
    }

    public static void main(String[] args) {
        Node Node8 = new Node(5, null);
        Node Node7 = new Node(7, Node8);
        Node Node6 = new Node(6, Node7);
        Node Node5 = new Node(5, Node6);
        Node Node4 = new Node(4, Node5);
        Node Node3 = new Node(5, Node4);
        Node Node2 = new Node(2, Node3);
        Node Node1 = new Node(5, Node2);
        Node head = new Node(9999999,Node1);

        Node myhead = deleteAllSuchElement2(head, 5).next;
        while (myhead != null){
            System.out.println(myhead.value);
            myhead = myhead.next;
        }
    }
}
