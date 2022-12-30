package library.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayStackTest {

    @Test
    public void testStackMaxSize(){
        int maxSize =  1000;
        ArrayStack<Integer> arrayStack =  new ArrayStack<>(maxSize);

        Assert.assertEquals(arrayStack.getMaxSize(), maxSize);
    }
    @Test
    public void testEmptyStack(){
        ArrayStack<Integer> arrayStack =  new ArrayStack<>();

        Assert.assertTrue(arrayStack.isEmpty());
        Assert.assertFalse(arrayStack.isFull());
        Assert.assertNull(arrayStack.peek());
    }

    @Test
    public void testPush(){
        int item = 10;
        ArrayStack<Integer> arrayStack =  new ArrayStack<>();
        arrayStack.push(item);

        Assert.assertFalse(arrayStack.isEmpty());
        Assert.assertEquals(arrayStack.peek(), item);
        Assert.assertFalse(arrayStack.isFull());
    }

    @Test
    public void testPop(){
        int item = 10;
        ArrayStack<Integer> arrayStack =  new ArrayStack<>();
        arrayStack.push(item);

        int poppedItem = arrayStack.pop();
        Assert.assertEquals(poppedItem, item);
    }

}
