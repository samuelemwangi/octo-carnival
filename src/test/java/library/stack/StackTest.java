package library.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StackTest {

    @Test
    public void testStackMaxSize(){
        int maxSize =  1000;
        Stack<Integer> stack =  new Stack<>(maxSize);

        Assert.assertEquals(stack.getMaxSize(), maxSize);
    }
    @Test
    public void testEmptyStack(){
        Stack<Integer> stack =  new Stack<>(100);

        Assert.assertTrue(stack.isEmpty());
        Assert.assertFalse(stack.isFull());
        Assert.assertNull(stack.peek());
    }

    @Test
    public void testPush(){
        int item = 10;
        Stack<Integer> stack =  new Stack<>(100);
        stack.push(item);

        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(stack.peek(), item);
        Assert.assertFalse(stack.isFull());
    }

    @Test
    public void testPop(){
        int item = 10;
        Stack<Integer> stack =  new Stack<>(100);
        stack.push(item);

        int poppedItem = stack.pop();
        Assert.assertEquals(poppedItem, item);
    }

}
