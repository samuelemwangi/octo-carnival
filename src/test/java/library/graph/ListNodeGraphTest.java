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
        graph.removeEdge(0,0);
        String expectedGraph =  "0->12\n1->20\n2->\n";
        Assert.assertEquals(graph.toString(), expectedGraph);
        graph.removeEdge(1, 0);
        expectedGraph = "0->12\n1->2\n2->\n";
        Assert.assertEquals(graph.toString(), expectedGraph);
    }

    @Test
    public void testDetectCycle() {
        ListNodeGraph<Integer> graph = new ListNodeGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);

        System.out.println(graph);
        Assert.assertTrue(graph.detectCycle());

        graph.removeEdge(1, 0);
        Assert.assertFalse(graph.detectCycle());

        graph.removeEdge(0, 1);
        System.out.println(graph);
        Assert.assertFalse(graph.detectCycle());
    }

    @Test
    public void testPathExists() {
        ListNodeGraph<Integer> graph = new ListNodeGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.addEdge(0,3);
        graph.addEdge(3,1);

        graph.addEdge(4,3);

        graph.addEdge(3,5);

        System.out.println(graph);
        Assert.assertTrue(graph.pathExists(4, 5));
        Assert.assertFalse(graph.pathExists(1,4));

        Assert.assertFalse(graph.pathExists(0,0));

        graph.addEdge(0,0);
        Assert.assertTrue(graph.pathExists(0,0));


        graph.addEdge(1,0);
        graph.addEdge(3,4);
        Assert.assertTrue(graph.pathExists(1,4));
    }


    @Test
    public void testCloneGraph(){
        ListNodeGraph<Integer> graph = new ListNodeGraph<>();
        graph.addEdge(1,2);
        graph.addEdge(2,1);

        graph.addEdge(1,4);
        graph.addEdge(4,1);

        graph.addEdge(2,3);
        graph.addEdge(3,2);

        graph.addEdge(4,3);
        graph.addEdge(3,4);

        ListNodeGraph<Integer> cloneGraph = graph.cloneGraph();

        Assert.assertEquals(graph.toString(), cloneGraph.toString());

    }

}
