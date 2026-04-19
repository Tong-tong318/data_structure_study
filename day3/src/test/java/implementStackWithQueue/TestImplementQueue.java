package implementStackWithQueue;

import org.junit.Assert;
import org.junit.Test;

public class TestImplementQueue {

    @Test
    public void Test1(){
        ImplementStack stack = new ImplementStack();
        stack.push(12);
        stack.push(44);
        stack.push(22);

        Assert.assertEquals(22, stack.pop());
        Assert.assertEquals(44, stack.top());
        stack.pop();
        Assert.assertFalse(stack.empty());
        stack.pop();
        Assert.assertTrue(stack.empty());
    }
}
