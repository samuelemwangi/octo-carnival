package library.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdjacencyListGraphTest {
    @Test
    public void testAddEdge(){
        int vertices =  2;
        AdjacencyListGraph graph =  new AdjacencyListGraph(vertices);
        graph.addEdge(0,1);

        String expectedGraph =  "0->1\n1->0\n";


        Assert.assertEquals(graph.toString(),expectedGraph);
    }

    @Test
    public void testRemoveEdge(){
        int vertices =  3;
        AdjacencyListGraph graph =  new AdjacencyListGraph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.removeEdge(0,1);

        String expectedGraph =  "0->2\n1->\n2->0\n";

        Assert.assertEquals(graph.toString(),expectedGraph);
    }
}
