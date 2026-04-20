package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class Traversal2 {
    public ArrayList<Integer> preTraversal(TreeNode node){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null) {
                arrayList.addLast((Integer) node.value);
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop().right;
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> midTraversal(TreeNode node){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                arrayList.addLast((Integer) node.value);
                node = node.right;
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> endTraversal(TreeNode node){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        while (node != null || !stack.isEmpty()){
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    node = peekNode.right;
                } else {
                    stack.pop();
                    arrayList.add((Integer) peekNode.value);
                    lastVisited = peekNode;
                }
            }
        }
        return arrayList;
    }
}
