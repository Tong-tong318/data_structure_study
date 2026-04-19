package binaryTree;

import org.junit.Test;

import java.util.ArrayList;

public class TestBinaryTreeTraversal {

    public static final TreeNode HEAD = new TreeNode(1,
            new TreeNode(2,
                    new TreeNode(4, null, null),
                    new TreeNode(5, null, null)
            ),
            new TreeNode(3,
                    new TreeNode(6, null, null),
                    new TreeNode(7, null, null)
            )
    );


    @Test
    public void TestLayerTraversal(){
        Traversal traversal = new Traversal();
        ArrayList<Object> list = traversal.LayerTraversal(HEAD);
        System.out.println(list);
    }

    @Test
    public void TestPreTraversal(){
        Traversal traversal = new Traversal();
        ArrayList<Object> list = traversal.preTralversal(HEAD);
        System.out.println(list);
    }

    @Test
    public void TestMidTraversal(){
        Traversal traversal = new Traversal();
        ArrayList<Object> list = traversal.midTralversal(HEAD);
        System.out.println(list);
    }

    @Test
    public void TestEndTraversal(){
        Traversal traversal = new Traversal();
        ArrayList<Object> list = traversal.endTralversal(HEAD);
        System.out.println(list);
    }
}
