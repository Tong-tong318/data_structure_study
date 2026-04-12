package binaryTree;

import org.junit.Test;
import queue.LinkedQueue;

import java.util.ArrayList;
import java.util.List;

public class TestBinaryTreeTraversal {
    @Test
    public void Test1(){
        TreeNode head = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4, null, null),
                new TreeNode(5, null, null)
            ),
            new TreeNode(3,
                new TreeNode(6, null, null),
                new TreeNode(7, null, null)
            )
        );

        LinkedQueue queue = new LinkedQueue();
        queue.offer(head);
        int count1 = 1;
        int count2 = 0;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < count1; i++) {
                TreeNode node = (TreeNode) queue.pull();
                if (node.left != null){
                    queue.offer(node.left);
                    count2++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    count2++;
                }

                list.add((Integer) node.value);
            }
            lists.add(list);
            count1 = count2;
            count2 = 0;
        }

        System.out.println(lists);
    }
}
