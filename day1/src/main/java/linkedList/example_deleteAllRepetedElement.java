package linkedList;

public class example_deleteAllRepetedElement {
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

    public static void main(String[] args) {
        Node Node8 = new Node(5, null);
        Node Node7 = new Node(5, Node8);
        Node Node6 = new Node(6, Node7);
        Node Node5 = new Node(3, Node6);
        Node Node4 = new Node(3, Node5);
        Node Node3 = new Node(3, Node4);
        Node Node2 = new Node(2, Node3);
        Node Node1 = new Node(7, Node2);
        Node head = new Node(9999999, Node1);

        Node myhead = deleteRepeated2(head).next;
        while (myhead != null) {
            System.out.println(myhead.value);
            myhead = myhead.next;
        }
    }

    private static Node deleteRepeated1(Node node) {
        if (node == null || node.next == null ) {
            return node;
        }
        if (node.value == node.next.value) {
            Node p1 = node.next.next;
            while (p1 != null && p1.value == node.value){
                p1 = p1.next;
            }
            return deleteRepeated1(p1);
        }else {
            node.next = deleteRepeated1(node.next);
            return node;
        }
    }

    private static Node deleteRepeated2(Node head){
        Node p1 = head;
        Node p2 = head.next;
        Node p3 = p2.next;
        while (p3 != null) {
            if (p2.value == p3.value) {
                while (p2.value == p3.value && p3.next != null) {
                    p3 = p3.next;
                }
                if (p3.value == p2.value){
                    p1.next = null;
                    return head;
                }
                p1.next = p3;
                p2 = p1.next;
                p3 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p1.next;
                p3 = p2.next;
            }
        }
        return head;
    }
}
