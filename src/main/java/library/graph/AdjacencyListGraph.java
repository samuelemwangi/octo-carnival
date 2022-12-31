package library.graph;

import java.util.LinkedList;

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

    public void addEdge(int i, int j){
        LinkedList<Integer> listI =  graph[i];
        LinkedList<Integer> listJ =  graph[j];

        listI.addLast(j);
        listJ.addLast(i);
    }

    public void removeEdge(int i, int j){
        LinkedList<Integer> listI =  graph[i];
        LinkedList<Integer> listJ =  graph[j];

        listI.removeFirstOccurrence(j);
        listJ.removeFirstOccurrence(i);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < vertices; i++){
            s.append(i).append("->");
            for (int j : graph[i]) {
                s.append(j);
            }
            s.append("\n");
        }

        return s.toString();
    }
}
