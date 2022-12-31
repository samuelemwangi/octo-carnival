package library.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListNodeGraphTest {

    @Test
    public void testEmpty(){
        ListNodeGraph<Integer> graph =  new ListNodeGraph<>();

        Assert.assertTrue(graph.isEmpty());
    }

    @Test
    public void testAddEdge(){
        ListNodeGraph<Integer> graph =  new ListNodeGraph<>();
        graph.addEdge(0,1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);

        graph.addEdge(0,0);
        graph.addEdge(1,0);


        Assert.assertFalse(graph.isEmpty());
        Assert.assertEquals(graph.vertices(), 3);
        String expectedGraph =  "0->120\n1->20\n2->\n";
        Assert.assertEquals(graph.toString(), expectedGraph);
    }

    @Test
    public void testRemoveEdge(){
        ListNodeGraph<Integer> graph =  new ListNodeGraph<>();
        graph.addEdge(0,1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);

        graph.addEdge(0,0);
        graph.addEdge(1,0);


        Assert.assertFalse(graph.isEmpty());
        Assert.assertEquals(graph.vertices(), 3);
        String expectedGraph =  "0->120\n1->20\n2->\n";
        Assert.assertEquals(graph.toString(), expectedGraph);
    }
}
