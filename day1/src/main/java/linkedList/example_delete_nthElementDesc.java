package linkedList;

public class example_delete_nthElementDesc {
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
        Node Node7 = new Node(7, Node8);
        Node Node6 = new Node(6, Node7);
        Node Node5 = new Node(5, Node6);
        Node Node4 = new Node(4, Node5);
        Node Node3 = new Node(5, Node4);
        Node Node2 = new Node(2, Node3);
        Node Node1 = new Node(5, Node2);
        Node head = new Node(9999999, Node1);

        Node myhead = delete_nth_element2(2, head).next;
        while (myhead != null) {
            System.out.println(myhead.value);
            myhead = myhead.next;
        }
    }

    private static Node delete_nth_element1(int target, Node head){
        delete_recusion(head, target);
        return head;
    }
    private static int delete_recusion(Node node, int target){
        if (node.next == null){return 1;}
        int i = delete_recusion(node.next, target);

        if (i == target){
            node.next = node.next.next;
        }
        return i+1;
    }


    private static Node delete_nth_element2(int target, Node head){
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < target; i++) {
            p2 = p2.next;
        }

        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}
