package binaryTree;

import org.junit.Assert;
import org.junit.Test;

public class TestCheakSymmetry {
    @Test
    public void Test(){
        CheakSymmetry<Integer> cheak = new CheakSymmetry<>();
         TreeNode<Integer> HEAD1 = new TreeNode<>(1,
                new TreeNode<>(2,
                        new TreeNode<>(4, null, null),
                        new TreeNode<>(5, null, null)
                ),
                new TreeNode<>(3,
                        new TreeNode<>(6, null, null),
                        new TreeNode<>(7, null, null)
                )
        );

        TreeNode<Integer> HEAD2 = new TreeNode<>(1,
                new TreeNode<>(2,
                        new TreeNode<>(4, null, null),
                        new TreeNode<>(5, null, null)
                ),
                new TreeNode<>(2,
                        new TreeNode<>(5, null, null),
                        new TreeNode<>(4, null, null)
                )
        );

        boolean cheak1 = cheak.cheak(HEAD1);
        boolean cheak2 = cheak.cheak(HEAD2.left, HEAD2.right);

        Assert.assertTrue(cheak2);
        Assert.assertFalse(cheak1);
    }
}
