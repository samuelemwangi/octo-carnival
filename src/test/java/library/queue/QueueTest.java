package library.queue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QueueTest {

    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<>();

        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue(){
        int item = 10;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);

        Assert.assertEquals(queue.peek(), item);
    }

    @Test
    public void testDequeue(){
        int item = 10;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        Assert.assertEquals(queue.peek(), item);
        Assert.assertEquals(queue.dequeue(), item);

        Assert.assertFalse(queue.isEmpty());
        queue.dequeue();
        Assert.assertEquals(queue.size(), 0);
    }

}
