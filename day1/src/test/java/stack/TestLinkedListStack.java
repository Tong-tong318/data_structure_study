package stack;

import org.junit.Assert;
import org.junit.Test;

public class TestLinkedListStack {
    @Test
    public void Test1(){
        LinkedListStack stack = new LinkedListStack();
        stack.pull("a");
        stack.pull(114);
        stack.pull(true);

        Object top1 = stack.pop();
        Object top2 = stack.pop();
        Object top3 = stack.pop();

        Assert.assertEquals(true, top1);
        Assert.assertEquals(114, top2);
        Assert.assertEquals("a", top3);
    }

    @Test
    public void Test2(){
        LinkedListStack stack = new LinkedListStack();
        stack.pull("a");
        stack.pull(114);
        stack.pull(true);

        Object top1 = stack.pop();
        Object top2 = stack.pop();
        Object top3 = stack.pop();
        Object top4 = stack.pop();

        Assert.assertNull(top4);
    }


}
