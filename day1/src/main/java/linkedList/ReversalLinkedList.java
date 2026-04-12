package linkedList;

public class ReversalLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        LinkedList reversal = reversal(list);
        reversal.forEach(
              value -> System.out.println(value)
        );
    }

    public static LinkedList reversal(LinkedList oraginList) {
        LinkedList newList = new LinkedList();
        while (!oraginList.isEmpty()) {
            Object val = oraginList.delete(0);
            newList.add(val, 0);
        }
        return newList;
    }
}
