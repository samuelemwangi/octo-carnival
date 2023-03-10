package library.queue;

import java.util.LinkedList;

public class LinkedQueue<T> {
    private int size;
    private final LinkedList<T> queue;

    public LinkedQueue(){
        queue = new LinkedList<>();
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T item){
        queue.addLast(item);
        size++;
    }

    public T peek(){
        return queue.peekFirst();
    }
    public T dequeue(){
        size--;
        return queue.removeFirst();
    }
}
