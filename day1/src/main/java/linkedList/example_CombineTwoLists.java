package linkedList;

public class example_CombineTwoLists {
    protected static class Node {
        int value;
        Node next;

        protected Node(){
        }
        protected Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node ANode8 = new Node(6, null);
        Node ANode7 = new Node(6, ANode8);
        Node ANode6 = new Node(6, ANode7);
        Node ANode5 = new Node(5, ANode6);
        Node ANode4 = new Node(4, ANode5);
        Node ANode3 = new Node(4, ANode4);
        Node ANode2 = new Node(2, ANode3);
        Node ANode1 = new Node(2, ANode2);
        Node Ahead = new Node(9999999, ANode1);


        Node BNode8 = new Node(8, null);
        Node BNode7 = new Node(7, BNode8);
        Node BNode6 = new Node(7, BNode7);
        Node BNode5 = new Node(7, BNode6);
        Node BNode4 = new Node(4, BNode5);
        Node BNode3 = new Node(3, BNode4);
        Node BNode2 = new Node(2, BNode3);
        Node BNode1 = new Node(1, BNode2);
        Node Bhead = new Node(9999999, BNode1);

        Node myhead = combineTwo(Ahead, Bhead).next;
        while (myhead != null) {
            System.out.println(myhead.value);
            myhead = myhead.next;
        }
    }



    protected static Node combineTwo(Node ahead, Node bhead){
        Node myhead = new Node(114514, null);
        Node p0 = myhead;
        Node p1 = ahead.next;
        Node p2 = bhead.next;

        while (true) {
            if (p1 == null) {
                p0.next = p2;
                return myhead;
            }
            if (p2 == null) {
                p0.next = p1;
                return myhead;
            }
            if (p1.value > p2.value) {
                p0.next = p2;
                p2 = p2.next;
                p0 = p0.next;
            } else {
                p0.next = p1;
                p1 = p1.next;
                p0 = p0.next;
            }
        }
    }

}
