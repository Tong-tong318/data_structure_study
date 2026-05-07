package binaryTree;

import java.util.Stack;

public class GetDepth {
    public int getMaxDepth1(TreeNode<Integer> node){
        if (node == null) return 0;
        int max = Integer.max(getMaxDepth1(node.left), getMaxDepth1(node.right));
        return max+1;
    }

    public int getMinDepth1(TreeNode<Integer> node){
        if (node == null) return 0;
        if(node.right == null && node.left == null) return 1;
        if(node.right == null) return getMinDepth1(node.left)+1;
        if(node.left == null) return getMinDepth1(node.right)+1;

        int min = Integer.min(getMinDepth1(node.left), getMinDepth1(node.right));
        return min+1;
    }

    public int getMaxDepth2(TreeNode<Integer> node){
        int depth = 0;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> lastVisit = null;
        TreeNode<Integer> peek;
        while (!stack.isEmpty() || node != null){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                depth = Integer.max(depth, stack.size());
                peek = stack.peek();
                if (peek.right == null || peek.right == lastVisit){
                    lastVisit = stack.pop();
                }else {
                    node = peek.right;
                }
            }
        }
        return depth;
    }
}
