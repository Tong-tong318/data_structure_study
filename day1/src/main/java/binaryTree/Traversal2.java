package binaryTree;

import queue.LinkedQueue;

import java.util.ArrayList;
import java.util.List;

public class Traversal2<E> {
    ArrayList<List<E>> arrayListofLayer = new ArrayList<>();
    ArrayList<E> arrayList = new ArrayList<>();

    /**
     * 层序遍历
     */
    public ArrayList<List<E>> LayerTraversal(TreeNode<E> head){

        LinkedQueue<TreeNode<E>> queue = new LinkedQueue<>();
        queue.offer(head);
        int count1 = 1;
        int count2 = 0;

        while (!queue.isEmpty()){
            List<E> list = new ArrayList<>();
            for (int i = 0; i < count1; i++) {
                TreeNode<E> node = queue.pull();
                if (node.left != null){
                    queue.offer(node.left);
                    count2++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    count2++;
                }

                list.add(node.value);
            }
            arrayListofLayer.add(list);
            count1 = count2;
            count2 = 0;
        }

        return arrayListofLayer;
    }

    /**
     * 前序遍历
     */
    public ArrayList<E> preTralversal(TreeNode<E> node){
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
    public ArrayList<E> midTralversal(TreeNode<E> node){
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
    public ArrayList<E> endTralversal(TreeNode<E> node){
        if (node != null) {
            endTralversal(node.left);
            endTralversal(node.right);
            arrayList.add(node.value);
            return arrayList;
        }
        return null;
    }
}
