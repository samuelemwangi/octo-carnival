package library.graph;

public class AdjacencyMatrixGraph {
    private final int vertices;
    private final boolean[][] graph;

    public AdjacencyMatrixGraph(int vertices) {
        this.vertices = vertices;
        graph = new boolean[vertices][vertices];
    }

    public void addEdge(int i, int j) {
        graph[i][j] = true;
        graph[j][i] = true;
    }

    public void removeEdge(int i, int j) {
        graph[i][j] = false;
        graph[j][i] = false;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < vertices; i++){
            for(boolean j : graph[i]){
                s.append(j ? 1 : 0);
            }
            s.append("\n");
        }
        return s.toString();
    }
}
