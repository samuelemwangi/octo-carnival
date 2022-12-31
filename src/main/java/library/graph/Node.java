package library.graph;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    public T data;
    public List<Node<T>> neighbors;
    public Node(T data){
        this.data = data;
        this.neighbors =  new ArrayList<>();
    }
}
