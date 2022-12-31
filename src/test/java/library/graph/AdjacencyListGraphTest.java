package library.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class AdjacencyListGraphTest {
    @Test
    public void testAddEdge() {
        int vertices = 2;
        AdjacencyListGraph graph = new AdjacencyListGraph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);

        String expectedGraph = "0->1\n1->0\n";


        Assert.assertEquals(graph.toString(), expectedGraph);
    }

    @Test
    public void testRemoveEdge() {
        int vertices = 3;
        AdjacencyListGraph graph = new AdjacencyListGraph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.removeEdge(0, 1);
        graph.removeEdge(1, 0);

        String expectedGraph = "0->2\n1->\n2->0\n";

        Assert.assertEquals(graph.toString(), expectedGraph);
    }

    @Test
    public void testBFSTraversal() {
        int vertices = 4;
        AdjacencyListGraph graph = new AdjacencyListGraph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        String expected = "0->1->2->3->";

        Assert.assertEquals(graph.bfsTraversal(), expected);
    }


    @Test
    public void testDFSTraversal() {
        int vertices = 4;
        AdjacencyListGraph graph = new AdjacencyListGraph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        String expected = "0->2->3->1->";

        Assert.assertEquals(graph.dfsTraversal(), expected);
    }

    @Test
    public void testDFSTraversalRecursive() {
        int vertices = 4;
        AdjacencyListGraph graph = new AdjacencyListGraph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        StringBuilder s = new StringBuilder();
        HashSet<Integer> items = new HashSet<>();

        graph.dfsTraversalRecursive(s, items, 0);

        String expected = "0->1->3->2->";

        Assert.assertEquals(s.toString(), expected);
    }


    @Test
    public void testDetectCycle() {
        AdjacencyListGraph graph = new AdjacencyListGraph(2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);

        Assert.assertTrue(graph.detectCycle());

        graph.removeEdge(1, 0);
        Assert.assertFalse(graph.detectCycle());

        graph.removeEdge(0, 1);
        Assert.assertFalse(graph.detectCycle());
    }

    @Test
    public void testDetectCycleRecursive() {
        AdjacencyListGraph graph = new AdjacencyListGraph(2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);

        Assert.assertTrue(graph.detectCycleRecursive(0, new HashSet<>()));

        graph.removeEdge(1, 0);
        Assert.assertFalse(graph.detectCycleRecursive(0, new HashSet<>()));

        graph.removeEdge(0, 1);
        Assert.assertFalse(graph.detectCycleRecursive(0, new HashSet<>()));
    }

    @Test
    public void testPathExists() {
        AdjacencyListGraph graph = new AdjacencyListGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.addEdge(0,3);
        graph.addEdge(3,1);

        graph.addEdge(4,3);

        graph.addEdge(3,5);

        Assert.assertTrue(graph.pathExists(4, 5));
        Assert.assertFalse(graph.pathExists(1,4));
    }
}
