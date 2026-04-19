package doublyArrayQueue;

import org.junit.Assert;
import org.junit.Test;

public class TestDoublyArrayQueue {
    @Test
    public void Test1() {
        DoublyArrayQueue<Integer> queue = new DoublyArrayQueue<>(5);

        queue.offerFirst(1);
        queue.offerLast(2);
        queue.offerLast(3);

        Assert.assertFalse(queue.isEmpty());

        Assert.assertEquals(Integer.valueOf(1), queue.peekFirst());
        Assert.assertEquals(Integer.valueOf(3), queue.peekLast());

        Assert.assertEquals(Integer.valueOf(1), queue.pullFirst());
        Assert.assertEquals(Integer.valueOf(3), queue.pullLast());
        Assert.assertEquals(Integer.valueOf(2), queue.pullFirst());

        Assert.assertTrue(queue.isEmpty());
        Assert.assertNull(queue.pullFirst());
    }

}
