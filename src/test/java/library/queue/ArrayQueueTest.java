package library.queue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayQueueTest {

    @Test
    public void testIsEmpty() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        Assert.assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testEnqueue(){
        int item = 10;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(10);

        Assert.assertEquals(arrayQueue.peek(), item);
    }

    @Test
    public void testDequeue(){
        int item = 10;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        Assert.assertEquals(arrayQueue.peek(), item);
        Assert.assertEquals(arrayQueue.dequeue(), item);

        Assert.assertFalse(arrayQueue.isEmpty());
        arrayQueue.dequeue();
        Assert.assertEquals(arrayQueue.size(), 0);
    }

}
