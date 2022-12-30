package library.stack;

import java.util.LinkedList;

public class StackV2<T> {
    private final LinkedList<T> stack;

    private int size;

    public StackV2(){
        stack = new LinkedList<>();
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T peek(){
       if(isEmpty())
           return null;

       return stack.peek();
    }

    public void push(T item){
        stack.addLast(item);
        size++;
    }
    public T pop(){
        size--;
        return stack.removeLast();
    }

}
