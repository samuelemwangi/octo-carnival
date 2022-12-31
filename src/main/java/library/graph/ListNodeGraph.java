package library.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ListNodeGraph<T> {
    private int vertices;
    public Node<T> sourceNode;

    public ListNodeGraph() {
        sourceNode = null;
        vertices = 0;
    }

    public boolean isEmpty() {
        return vertices == 0;
    }

    public int vertices() {
        return vertices;
    }

    public void addEdge(T source, T destination) {
        if (isEmpty()) {
            this.sourceNode = new Node<>(source);
            this.sourceNode.neighbors.add(new Node<>(destination));
            vertices = 2;
            return;
        }

        Node<T> sourceNode = searchNodeBFS(source);
        if (sourceNode == null) {
            // No islands allowed
            return;
        }

        Node<T> destNode = searchNodeBFS(destination);

        if (destNode == null) {
            sourceNode.neighbors.add(new Node<>(destination));
            vertices++;
        } else {
            sourceNode.neighbors.add(destNode);
        }
    }


    public void removeEdge(T source, T destination){
        if(isEmpty())
            return;
        Node<T> sourceNode =  searchNodeBFS(source);
        if(sourceNode == null)
            return;

        Node<T> destNode =  searchNodeBFS(destination);
        if(destNode == null)
            return;

        sourceNode.neighbors.remove(destNode);

    }


    public Node<T> searchNodeBFS(T nodeValue) {
        Queue<Node<T>> queue = new LinkedList<>();
        HashSet<Node<T>> tracker = new HashSet<>();
        queue.offer(sourceNode);
        tracker.add(sourceNode);

        while (queue.peek() != null) {
            Node<T> item = queue.poll();
            if (item.data.equals(nodeValue))
                return item;

            for (Node<T> neighbor : item.neighbors) {
                if (!tracker.contains(neighbor)) {
                    queue.offer(neighbor);
                    tracker.add(neighbor);
                }
            }
        }

        return null;
    }


    public String toString(){
        StringBuilder  s = new StringBuilder();

        Node<T> currNode =  sourceNode;

        while (currNode != null){
            s.append(currNode.data).append("->");

            Queue<Node<T>> queue =  new LinkedList<>();
            HashSet<Node<T>> tracker =  new HashSet<>();
            tracker.add(currNode);
            for (Node<T> neighbor : currNode.neighbors){
                s.append(neighbor.data);
                if(!tracker.contains(neighbor))
                    queue.offer(neighbor);
            }
            s.append("\n");
            currNode = queue.poll();
        }

        return s.toString();
    }


}
