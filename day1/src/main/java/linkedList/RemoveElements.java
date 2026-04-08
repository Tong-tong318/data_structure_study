package linkedList;

public class RemoveElements {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(4);
        list.addLast(2);
        list.addLast(6);
        list.addLast(2);
        list.addLast(2);

        LinkedList removed = removeElements(list, 2);
        list.forEach(
                value -> System.out.println(value)
        );
        System.out.println("___________________________________________");
        removed.forEach(
                value -> System.out.println(value)
        );
    }

    public static LinkedList removeElements(LinkedList originList, int target){
        LinkedList newList = new LinkedList();
        for (int i = 0; i < originList.getLength(); i++) {
            int value = originList.get(i);
            if (value != target) {
                newList.addLast(value);
            }
        }
        return newList;
    }
}
