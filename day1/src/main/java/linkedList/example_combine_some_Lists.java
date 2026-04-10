package linkedList;

public class example_combine_some_Lists extends example_CombineTwoLists{
    public static void main(String[] args) {
        Node[] nodes = init();
        Node myhead = devideLists(nodes, 0, 3).next;
        while (myhead != null) {
            System.out.println(myhead.value);
            myhead = myhead.next;
        }
    }

    private static Node devideLists(Node[] nodes, int begin, int end){
        if (end == begin){
            return nodes[begin];
        }
        if (end - begin == 1){
            return combineTwo(nodes[begin],nodes[end]);
        }

        int mid = (begin + end) >>> 1;
        Node prev = devideLists(nodes, begin, mid);
        Node next = devideLists(nodes, mid + 1, end);
        return combineTwo(prev, next);
    }

    protected static Node[] init(){

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

        Node CNode8 = new Node(9, null);
        Node CNode7 = new Node(8, CNode8);
        Node CNode6 = new Node(7, CNode7);
        Node CNode5 = new Node(6, CNode6);
        Node CNode4 = new Node(5, CNode5);
        Node CNode3 = new Node(4, CNode4);
        Node CNode2 = new Node(3, CNode3);
        Node CNode1 = new Node(2, CNode2);
        Node Chead = new Node(9999999, CNode1);

        Node DNode8 = new Node(9, null);
        Node DNode7 = new Node(9, DNode8);
        Node DNode6 = new Node(8, DNode7);
        Node DNode5 = new Node(7, DNode6);
        Node DNode4 = new Node(6, DNode5);
        Node DNode3 = new Node(5, DNode4);
        Node DNode2 = new Node(4, DNode3);
        Node DNode1 = new Node(3, DNode2);
        Node Dhead = new Node(9999999, DNode1);

        Node[] nodes = {Ahead, Bhead, Chead, Dhead};
        return nodes;
    }
}

