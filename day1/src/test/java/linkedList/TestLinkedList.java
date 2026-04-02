package linkedList;

import org.junit.Test;

public class TestLinkedList {
    @Test
    public void Test1(){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(0);
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.forEach(value -> System.out.println(value));
    }

    @Test
    public void Test2(){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(0);
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.delete(2);
        linkedList.forEach(value -> System.out.println(value));
    }
}
