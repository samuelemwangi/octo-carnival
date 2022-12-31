package library.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyListGraph {
    private final int vertices;
    private final LinkedList<Integer>[] graph;


    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int vertices) {
        this.vertices = vertices;
        graph = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j) {
        LinkedList<Integer> listI = graph[i];
        listI.addLast(j);
    }

    public void removeEdge(int i, int j) {
        LinkedList<Integer> listI = graph[i];
        listI.removeFirstOccurrence(j);
    }

    public String bfsTraversal() {
        HashSet<Integer> result = new HashSet<>();
        StringBuilder s = new StringBuilder();

        if (vertices < 1) return "";

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        result.add(0);

        while (queue.peek() != null) {
            int item = queue.poll();
            s.append(item).append("->");
            for (int neighbor : graph[item]) {
                if (!result.contains(neighbor)) {
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }

        return s.toString();
    }

    public String dfsTraversal() {
        HashSet<Integer> result = new HashSet<>();
        StringBuilder s = new StringBuilder();

        if (vertices < 1) return "";

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result.add(0);

        while (!stack.empty()) {
            int item = stack.pop();
            s.append(item).append("->");
            for (int neighbor : graph[item]) {
                if (!result.contains(neighbor)) {
                    stack.push(neighbor);
                    result.add(neighbor);
                }
            }
        }


        return s.toString();
    }

    public void dfsTraversalRecursive(StringBuilder s, HashSet<Integer> items, int node) {
        s.append(node).append("->");
        for (int neighbor : graph[node]) {
            if (!items.contains(neighbor)) {
                items.add(neighbor);
                dfsTraversalRecursive(s, items, neighbor);
            }
        }
    }

    public boolean detectCycle() {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> tracker = new HashSet<>();

        stack.push(0);
        tracker.add(0);

        while (!stack.empty()) {
            int item = stack.pop();
            for (int neighbor : graph[item]) {
                if (tracker.contains(neighbor)) {
                    return true;
                }
                tracker.add(neighbor);
                stack.push(neighbor);
            }

        }

        return false;
    }

    public boolean detectCycleRecursive(int node, HashSet<Integer> tracker) {

        for (int neighbor : graph[node]) {
            if (tracker.contains(neighbor)) {
                return true;
            }

            tracker.add(neighbor);
            return detectCycleRecursive(neighbor, tracker);
        }
        return false;

    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < vertices; i++) {
            s.append(i).append("->");
            for (int j : graph[i]) {
                s.append(j);
            }
            s.append("\n");
        }

        return s.toString();
    }


}
