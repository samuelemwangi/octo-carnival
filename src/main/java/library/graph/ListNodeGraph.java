package library.graph;

import java.util.HashMap;
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
        Node<T> destNode = searchNodeBFS(destination);

        if (sourceNode == null && destNode == null) {
            //  Add an island
            Node<T> islandSource = new Node<>(source);
            Node<T> islandDest = new Node<>(destination);

            islandSource.neighbors.add(islandDest);
            vertices += 2;
            return;
        }


        if (sourceNode != null && destNode == null) {
            sourceNode.neighbors.add(new Node<>(destination));
            vertices++;
            return;
        }

        if (sourceNode == null) {
            destNode.neighbors.add(new Node<>(source));
            vertices++;
            return;
        }

        sourceNode.neighbors.add(destNode);

    }


    public void removeEdge(T source, T destination) {
        if (isEmpty())
            return;
        Node<T> sourceNode = searchNodeBFS(source);
        if (sourceNode == null)
            return;

        Node<T> destNode = searchNodeBFS(destination);
        if (destNode == null)
            return;

        sourceNode.neighbors.remove(destNode);

    }

    public boolean detectCycle() {
        Queue<Node<T>> queue = new LinkedList<>();
        HashSet<Node<T>> tracker = new HashSet<>();
        queue.offer(sourceNode);
        tracker.add(sourceNode);

        while (queue.peek() != null) {
            Node<T> item = queue.poll();
            for (Node<T> neighbor : item.neighbors) {
                if (tracker.contains(neighbor)) {
                    return true;
                } else {
                    queue.offer(neighbor);
                    tracker.add(neighbor);
                }
            }

        }
        return false;
    }


    public boolean pathExists(T source, T dest) {
        Queue<Node<T>> queue = new LinkedList<>();
        HashSet<Node<T>> tracker = new HashSet<>();

        Node<T> sourceNode = searchNodeBFS(source);
        if (sourceNode == null)
            return false;
        Node<T> destNode = searchNodeBFS(dest);
        if (destNode == null)
            return false;

        queue.offer(sourceNode);
        tracker.add(sourceNode);

        while (queue.peek() != null) {
            Node<T> item = queue.poll();

            for (Node<T> neighbor : item.neighbors) {
                if (sourceNode.data.equals(neighbor.data)) {
                    return true;
                }

                if (!tracker.contains(neighbor)) {
                    queue.offer(neighbor);
                    tracker.add(neighbor);
                }
            }
        }

        return false;
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


    public ListNodeGraph<T> cloneGraph(){
        ListNodeGraph<T> newGraph =  new ListNodeGraph<>();
        if(isEmpty())
            return null;

        Node<T> clonedSourceNode =  new Node<>(sourceNode.data);
        newGraph.sourceNode = clonedSourceNode;

        Queue<Node<T>> queue = new LinkedList<>();
        HashMap<T, Node<T>> tracker =  new HashMap<>();

        queue.offer(sourceNode);
        queue.offer(clonedSourceNode);

        tracker.put(sourceNode.data, clonedSourceNode);


        while (queue.peek() != null){
            Node<T> item =  queue.poll();
            Node<T> clonedItem =  queue.poll();

            for (Node<T> neighbor : item.neighbors){
                if(tracker.containsKey(neighbor.data)){
                    clonedItem.neighbors.add(tracker.get(neighbor.data));
                }else{
                    Node<T> clonedNeighbor =  new Node<>(neighbor.data);
                    queue.offer(neighbor);
                    queue.offer(clonedNeighbor);
                    tracker.put(neighbor.data, clonedNeighbor);

                    clonedItem.neighbors.add(clonedNeighbor);
                }
            }
        }

        return newGraph;
    }

    public String toString() {
        Queue<Node<T>> queue = new LinkedList<>();
        HashSet<Node<T>> tracker = new HashSet<>();
        StringBuilder s = new StringBuilder();

        if (sourceNode == null)
            return "";

        queue.offer(sourceNode);
        tracker.add(sourceNode);

        while (queue.peek() != null) {
            Node<T> item = queue.poll();
            s.append(item.data).append("->");
            for (Node<T> neighbor : item.neighbors) {
                s.append(neighbor.data);
                if (!tracker.contains(neighbor)) {
                    queue.offer(neighbor);
                    tracker.add(neighbor);
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
