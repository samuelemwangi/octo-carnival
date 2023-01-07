package library.queue;

public class ArrayQueue<T> {
    private int size;
    private final T[] queue;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public ArrayQueue(){
        int maxSize = 4096;
        size = 0;
        head = -1;
        tail = -1;
        queue = (T[]) new Object[maxSize];
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T item){
         queue[++head] = item;
         if(size == 0){
             tail++;
         }

        size++;
    }

    public T peek(){
        if(isEmpty())
            return null;
        return queue[tail];
    }
    public T dequeue(){
        if(isEmpty())
            return null;
        size--;
        return queue[tail++];
    }

}
