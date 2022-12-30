package library.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StackV2Test {

    @Test
    public void testEmptyStack(){
        StackV2<Integer> stack =  new StackV2<>();

        Assert.assertTrue(stack.isEmpty());
        Assert.assertNull(stack.peek());
    }
    @Test
    public void testPush(){
        int item = 10;
        StackV2<Integer> stack =  new StackV2<>();
        stack.push(item);

        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(stack.peek(), item);
    }
    @Test
    public void testPop(){
        int item = 10;
        StackV2<Integer> stack =  new StackV2<>();
        stack.push(item);

        int poppedItem = stack.pop();
        Assert.assertEquals(poppedItem, item);
    }
}
