package suffixExpression;

import binaryTree.TreeNode;

import java.util.Stack;

public class SuffixToTree {
    public TreeNode<String> suffixToTree(String string){
        String[] chars = string.split(" ");
        Stack<TreeNode<String>> stack = new Stack<>();
        for (String token : chars){
            switch (token){
                case "+", "-", "*", "/" -> {
                    TreeNode<String> pop1 = stack.pop();
                    TreeNode<String> pop2 = stack.pop();
                    TreeNode<String> node = new TreeNode<>(token, pop2, pop1);
                    stack.push(node);
                }default -> {
                    stack.push(new TreeNode<>(token, null, null));
                }
            }
        }

        if (stack.size() != 1){
            throw new RuntimeException("后缀表达式有误！");
        }

        return stack.pop();
    }
}
