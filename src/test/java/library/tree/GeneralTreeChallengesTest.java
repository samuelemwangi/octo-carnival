package library.tree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneralTreeChallengesTest {

    @Test
    public void testDFSTraversal() {
        Node<Character> root = new Node<>('a'),
                b = new Node<>('b'),
                c = new Node<>('c'),
                d = new Node<>('d'),
                e = new Node<>('e'),
                f = new Node<>('f');

        root.leftChild = b;
        root.rightChild = c;

        b.leftChild = d;
        b.rightChild = e;

        c.rightChild =  f;

        GeneralTreeChallenges<Character> challenges =  new GeneralTreeChallenges<>();
        String expected =  "a,b,d,e,c,f,";
        Assert.assertEquals(challenges.dfsTraversalIterative(root), expected);
        Assert.assertEquals(challenges.dfsTraversalRecursive(root), expected);
    }

    @Test
    public void testBFSTraversal(){
        Node<Character> root = new Node<>('a'),
                b = new Node<>('b'),
                c = new Node<>('c'),
                d = new Node<>('d'),
                e = new Node<>('e'),
                f = new Node<>('f');

        root.leftChild = b;
        root.rightChild = c;

        b.leftChild = d;
        b.rightChild = e;

        c.rightChild =  f;

        GeneralTreeChallenges<Character> challenges =  new GeneralTreeChallenges<>();
        String expected =  "a,b,c,d,e,f,";
        Assert.assertEquals(challenges.bfsTraversal(root), expected);
    }

    @Test
    public void testSearch(){
        Node<Integer> root = new Node<>(10),
                b = new Node<>(5),
                c = new Node<>(8),
                d = new Node<>(4),
                e = new Node<>(11),
                f = new Node<>(4);

        root.leftChild = b;
        root.rightChild = c;

        b.leftChild = d;
        b.rightChild = e;

        c.rightChild =  f;

        GeneralTreeChallenges<Integer> challenges =  new GeneralTreeChallenges<>();
        Assert.assertTrue(challenges.searchIterative(root, 11));
        Assert.assertFalse(challenges.searchIterative(root, 21));

        Assert.assertTrue(challenges.searchRecursive(root, 8));
        Assert.assertFalse(challenges.searchIterative(root, 1));
    }
}
