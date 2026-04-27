package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class Traversal<E> {
    public ArrayList<E> preTraversal(TreeNode<E> node){
        ArrayList<E> arrayList = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null) {
                arrayList.addLast((E) node.value);
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop().right;
            }
        }
        return arrayList;
    }

    public ArrayList<E> midTraversal(TreeNode<E> node){
        ArrayList<E> arrayList = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                arrayList.addLast(node.value);
                node = node.right;
            }
        }
        return arrayList;
    }

    public ArrayList<E> endTraversal(TreeNode<E> node){
        ArrayList<E> arrayList = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> lastVisited = null;
        while (node != null || !stack.isEmpty()){
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                TreeNode<E> peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    node = peekNode.right;
                } else {
                    stack.pop();
                    arrayList.add(peekNode.value);
                    lastVisited = peekNode;
                }
            }
        }
        return arrayList;
    }
}
