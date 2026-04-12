package queue;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayQueue {
    @Test
    public void Test1(){
        ArrayQueue queue = new ArrayQueue(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.forEach(
                o -> System.out.println(o)
        );
    }

    @Test
    public void Test2(){
        ArrayQueue queue = new ArrayQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.pull();
        queue.pull();

        Assert.assertEquals(3, queue.peek());
    }
}

