package queue;

import org.junit.Assert;
import org.junit.Test;

public class TestLinkedQueue {
    @Test
    public void Test1(){
        LinkedQueue queue = new LinkedQueue();
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
        LinkedQueue queue = new LinkedQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.pull();
        queue.pull();

        Assert.assertEquals(3, queue.peek());
    }
}
