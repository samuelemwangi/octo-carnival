package library.queue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedQueueTest {

    @Test
    public void testIsEmpty() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue(){
        int item = 10;
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(10);

        Assert.assertEquals(queue.peek(), item);
    }

    @Test
    public void testDequeue(){
        int item = 10;
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        Assert.assertEquals(queue.peek(), item);
        Assert.assertEquals(queue.dequeue(), item);

        Assert.assertFalse(queue.isEmpty());
        queue.dequeue();
        Assert.assertEquals(queue.size(), 0);
    }
}
