package library.queue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QueueV2Test {

    @Test
    public void testIsEmpty() {
        QueueV2<Integer> queue = new QueueV2<>();

        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue(){
        int item = 10;
        QueueV2<Integer> queue = new QueueV2<>();
        queue.enqueue(10);

        Assert.assertEquals(queue.peek(), item);
    }

    @Test
    public void testDequeue(){
        int item = 10;
        QueueV2<Integer> queue = new QueueV2<>();
        queue.enqueue(10);
        queue.enqueue(20);
        Assert.assertEquals(queue.peek(), item);
        Assert.assertEquals(queue.dequeue(), item);

        Assert.assertFalse(queue.isEmpty());
        queue.dequeue();
        Assert.assertEquals(queue.size(), 0);
    }
}
