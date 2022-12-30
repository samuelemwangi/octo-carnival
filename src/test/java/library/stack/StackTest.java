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

}
