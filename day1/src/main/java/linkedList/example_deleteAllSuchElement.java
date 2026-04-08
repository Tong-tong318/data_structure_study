package linkedList;

public class example_deleteAllSuchElement {


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
        Node head = new Node(9999999, Node1);

        Node myhead = deleteAllSuchElement2(head, 5).next;
        while (myhead != null) {
            System.out.println(myhead.value);
            myhead = myhead.next;
        }
    }
}
