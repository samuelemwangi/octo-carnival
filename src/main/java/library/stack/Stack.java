package library.stack;

public class Stack<T> {
    private final int maxSize;
    private int top;
    private T[] array;


    @SuppressWarnings("unchecked")
    public Stack(int maxSize){
        this.maxSize =  maxSize;
        top =  -1;
        array = (T[]) new Object[maxSize];
    }
    public int getMaxSize() {
        return maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public T peek(){
        if(isEmpty())
            return null;
        return array[top];
    }

}
