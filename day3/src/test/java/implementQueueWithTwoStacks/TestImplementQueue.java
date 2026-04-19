package implementQueueWithTwoStacks;

import org.junit.Assert;
import org.junit.Test;

public class TestImplementQueue {
    @Test
    public void Test1(){
        ImplementQueue queue = new ImplementQueue();
        queue.push(2);
        queue.push(12);
        queue.push(44);

        Assert.assertEquals(2, queue.peek());
        queue.pop();
        Assert.assertEquals(12, queue.pop());
        Assert.assertFalse(queue.isEmpty());
        queue.pop();
        Assert.assertTrue(queue.isEmpty());
    }

}
