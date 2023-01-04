package library.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ListNodeGraph<T> {
    private int vertices;
    public final HashMap<T, Node<T>> sourceNodeTracker;

    public ListNodeGraph() {
        vertices = 0;
        sourceNodeTracker = new HashMap<>();
    }

    public boolean isEmpty() {
        return vertices == 0;
    }

    public int vertices() {
        return vertices;
    }

    public void addEdge(T source, T destination) {
        if (isEmpty()) {
            Node<T> sourceNode = new Node<>(source);
            if(source.equals(destination)) {
                sourceNode.neighbors.add(sourceNode);
                vertices = 1;
            }else {
                sourceNode.neighbors.add(new Node<>(destination));
                vertices = 2;
            }
            sourceNodeTracker.put(source, sourceNode);
            return;
        }

        Node<T> sourceNode = searchNodeBFS(source);
        Node<T> destNode = searchNodeBFS(destination);

        if (sourceNode == null && destNode == null) {
            //  Add an island
            Node<T> islandSource = new Node<>(source);
            Node<T> islandDest = new Node<>(destination);

            sourceNodeTracker.put(source, islandSource);

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
            Node<T> externalSourceNode =  new Node<>(source);
            externalSourceNode.neighbors.add(destNode);
            sourceNodeTracker.put(source, externalSourceNode);
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

    public boolean detectCycle(){
        for(Map.Entry<T, Node<T>> entry : sourceNodeTracker.entrySet()){
            if(detectCycle(entry.getValue()))
                return true;
        }

        return false;
    }

    public boolean detectCycle(Node<T> sourceNode) {
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
                if (neighbor.data.equals(dest)) {
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

    public Node<T> searchNodeBFS(T nodeValue){

        for(Map.Entry<T, Node<T>> entry : sourceNodeTracker.entrySet()){
            Node<T> targetNode =  searchNodeBFS(nodeValue, entry.getValue());
            if(targetNode != null)
                return targetNode;
        }

        return null;
    }

    public Node<T> searchNodeBFS(T nodeValue, Node<T> sourceNode) {
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


    public ListNodeGraph<T> cloneGraph(Node<T> sourceNode){
        ListNodeGraph<T> newGraph =  new ListNodeGraph<>();
        if(isEmpty())
            return null;

        Node<T> clonedSourceNode =  new Node<>(sourceNode.data);

        Queue<Node<T>> queue = new LinkedList<>();
        HashMap<T, Node<T>> tracker =  new HashMap<>();

        queue.offer(sourceNode);
        queue.offer(clonedSourceNode);

        tracker.put(sourceNode.data, clonedSourceNode);


        while (queue.peek() != null){
            Node<T> item =  queue.poll();
            Node<T> clonedItem =  queue.poll();

            if(sourceNodeTracker.containsKey(item.data))
                newGraph.sourceNodeTracker.put(item.data, clonedItem);


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

    public String toString(){
        StringBuilder s =  new StringBuilder();
        for(Map.Entry<T, Node<T>> entry : sourceNodeTracker.entrySet()){
            s.append(toString(entry.getValue()));
            s.append("\n\n");
        }

        return s.toString();
    }

    public String toString(Node<T> sourceNode) {
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
