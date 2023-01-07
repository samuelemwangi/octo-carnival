package library.linkedlist;

public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> nextNode;
    public Node<T> prevNode;
}
