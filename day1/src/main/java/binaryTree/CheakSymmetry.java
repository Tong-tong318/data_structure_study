package binaryTree;

public class CheakSymmetry<E> {
    public boolean cheak(TreeNode<E> left, TreeNode<E> right) {

        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (!left.value.equals(right.value)) return false;

        return (cheak(left.left, right.right) && cheak(left.right, right.left));
    }

    public boolean cheak(TreeNode<E> head){
        return cheak(head.left, head.right);
    }
}
