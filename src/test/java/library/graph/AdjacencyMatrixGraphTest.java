package library.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdjacencyMatrixGraphTest {

    @Test
    public void testAddEdge(){
        int vertices =  2;
        AdjacencyMatrixGraph graph =  new AdjacencyMatrixGraph(vertices);
        graph.addEdge(0,1);

        String expectedGraph =  "01\n10\n";

        Assert.assertEquals(graph.toString(),expectedGraph);
    }

    @Test
    public void testRemoveEdge(){
        int vertices =  2;
        AdjacencyMatrixGraph graph =  new AdjacencyMatrixGraph(vertices);
        graph.addEdge(0,1);
        graph.removeEdge(0,1);

        String expectedGraph =  "00\n00\n";

        Assert.assertEquals(graph.toString(),expectedGraph);
    }
}
