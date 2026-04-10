package queue;

import org.junit.Assert;
import org.junit.Test;

public class TestQueue {
    @Test
    public void Test1(){
        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.foreach(
                o -> System.out.println(o)
        );
    }

    @Test
    public void Test2(){
        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.pull();
        queue.pull();

        Assert.assertEquals(3, queue.peek());
    }
}
