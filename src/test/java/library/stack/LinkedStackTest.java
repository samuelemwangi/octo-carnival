package library.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedStackTest {

    @Test
    public void testEmptyStack(){
        LinkedStack<Integer> stack =  new LinkedStack<>();

        Assert.assertTrue(stack.isEmpty());
        Assert.assertNull(stack.peek());
    }
    @Test
    public void testPush(){
        int item = 10;
        LinkedStack<Integer> stack =  new LinkedStack<>();
        stack.push(item);

        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(stack.peek(), item);
    }
    @Test
    public void testPop(){
        int item = 10;
        LinkedStack<Integer> stack =  new LinkedStack<>();
        stack.push(item);

        int poppedItem = stack.pop();
        Assert.assertEquals(poppedItem, item);
    }
}
