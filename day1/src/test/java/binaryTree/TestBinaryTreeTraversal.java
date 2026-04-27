package binaryTree;

import org.junit.Test;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;

public class TestBinaryTreeTraversal {

    public static final TreeNode<Integer> HEAD = new TreeNode<>(1,
            new TreeNode<>(2,
                    new TreeNode<>(4, null, null),
                    new TreeNode<>(5, null, null)
            ),
            new TreeNode<>(3,
                    new TreeNode<>(6, null, null),
                    new TreeNode<>(7, null, null)
            )
    );


    @Test
    public void TestLayerTraversal(){
        Traversal2<Integer> traversal = new Traversal2<>();
        ArrayList<List<Integer>> list = traversal.LayerTraversal(HEAD);
        System.out.println(list);
    }
    @Test
    public void TestPreTraversal(){
        Traversal<Integer> traversal = new Traversal<>();
        ArrayList<Integer> list = traversal.preTraversal(HEAD);
        System.out.println(list);
    }

    @Test
    public void TestMidTraversal(){
        Traversal<Integer> traversal = new Traversal<>();
        ArrayList<Integer> list = traversal.midTraversal(HEAD);
        System.out.println(list);
    }

    @Test
    public void TestEndTraversal(){
        Traversal<Integer> traversal = new Traversal<>();
        ArrayList<Integer> list = traversal.endTraversal(HEAD);
        System.out.println(list);
    }
}
