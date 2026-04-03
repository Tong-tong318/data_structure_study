package doublyLinkedList;

import org.junit.Test;

public class TestDoublyLinkedList {
    @Test
    public void Test01(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(0);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addFirst(-1);
        doublyLinkedList.add(3,22);

        doublyLinkedList.ForEach(element -> System.out.println(element));
    }

    @Test
    public void Test02(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(0);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addFirst(-1);

        doublyLinkedList.delete(1);
        doublyLinkedList.update(2, 0);

        doublyLinkedList.ForEach(element -> System.out.println(element));
    }
}
