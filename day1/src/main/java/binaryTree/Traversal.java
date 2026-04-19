package binaryTree;

import queue.LinkedQueue;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    ArrayList<Object> arrayList = new ArrayList<>();

    /**
     * 层序遍历
     */
    public ArrayList<Object> LayerTraversal(TreeNode head){

        LinkedQueue queue = new LinkedQueue();
        queue.offer(head);
        int count1 = 1;
        int count2 = 0;

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
            arrayList.add(list);
            count1 = count2;
            count2 = 0;
        }

        return arrayList;
    }

    /**
     * 前序遍历
     */
    public ArrayList<Object> preTralversal(TreeNode node){
        if (node != null) {
            arrayList.add(node.value);
            preTralversal(node.left);
            preTralversal(node.right);
            return arrayList;
        }
        return null;
    }

    /**
     * 中序遍历
     */
    public ArrayList<Object> midTralversal(TreeNode node){
        if (node != null) {
            midTralversal(node.left);
            arrayList.add(node.value);
            midTralversal(node.right);
            return arrayList;
        }
        return null;
    }

    /**
     * 后序遍历
     */
    public ArrayList<Object> endTralversal(TreeNode node){
        if (node != null) {
            endTralversal(node.left);
            endTralversal(node.right);
            arrayList.add(node.value);
            return arrayList;
        }
        return null;
    }
}
