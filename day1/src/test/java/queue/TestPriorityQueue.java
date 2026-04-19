package queue;

import entity.PriorityNode;
import org.junit.Assert;
import org.junit.Test;

public class TestPriorityQueue {
    @Test
    public void Test01(){
        PriorityNode<Integer> p1 = new PriorityNode<>(1314, 2);
        PriorityNode<Integer> p2 = new PriorityNode<>(520, 4);
        PriorityNode<Integer> p3 = new PriorityNode<>(114, 1);
        PriorityQueue<PriorityNode<Integer>> queue = new PriorityQueue<>();
        queue.offer(p1);
        queue.offer(p2);
        queue.offer(p3);

        Assert.assertEquals(520,(int) queue.peek().getValue());
        queue.pull();
        Assert.assertEquals(1314,(int) queue.pull().getValue());
        Assert.assertEquals(114,(int) queue.peek().getValue());
        Assert.assertFalse(queue.isEmpty());
        queue.pull();
        Assert.assertTrue(queue.isEmpty());
    }




}
