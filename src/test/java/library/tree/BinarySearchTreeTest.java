package library.tree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTreeTest {

    @Test
    public void testIsEmpty() {
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        Assert.assertTrue(bst1.isEmpty());

        BinarySearchTree<Character> bst2 = new BinarySearchTree<>();
        Assert.assertTrue(bst2.isEmpty());
    }

    @Test
    public void testInsert() {
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        bst1.insert(23);
        Assert.assertFalse(bst1.isEmpty());
        Assert.assertEquals(bst1.root.data, 23);
        Assert.assertNull(bst1.root.leftChild);
        Assert.assertNull(bst1.root.rightChild);

        BinarySearchTree<Character> bst2 = new BinarySearchTree<>();
        bst2.insert('c');
        Assert.assertFalse(bst2.isEmpty());
        Assert.assertEquals(bst2.root.data, 'c');
        Assert.assertNull(bst2.root.leftChild);
        Assert.assertNull(bst2.root.rightChild);

        BinarySearchTree<Float> bst3 = new BinarySearchTree<>();
        bst3.insert(40.1F);
        bst3.insert(40F);
        bst3.insert(40.11F);

        Assert.assertFalse(bst3.isEmpty());
        Assert.assertEquals(bst3.root.data, 40.1F);
        Assert.assertEquals(bst3.root.leftChild.data, 40F);
        Assert.assertEquals(bst3.root.rightChild.data, 40.11F);
    }

    @Test
    public void testInsertRecursive() {
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        bst1.insertRecursive(23);
        Assert.assertFalse(bst1.isEmpty());
        Assert.assertEquals(bst1.root.data, 23);
        Assert.assertNull(bst1.root.leftChild);
        Assert.assertNull(bst1.root.rightChild);

        BinarySearchTree<Character> bst2 = new BinarySearchTree<>();
        bst2.insertRecursive('c');
        Assert.assertFalse(bst2.isEmpty());
        Assert.assertEquals(bst2.root.data, 'c');
        Assert.assertNull(bst2.root.leftChild);
        Assert.assertNull(bst2.root.rightChild);

        BinarySearchTree<Float> bst3 = new BinarySearchTree<>();
        bst3.insertRecursive(40.1F);
        bst3.insertRecursive(40F);
        bst3.insertRecursive(40.11F);

        Assert.assertFalse(bst3.isEmpty());
        Assert.assertEquals(bst3.root.data, 40.1F);
        Assert.assertEquals(bst3.root.leftChild.data, 40F);
        Assert.assertEquals(bst3.root.rightChild.data, 40.11F);
    }

    @Test
    public void testSearchRecursive() {
        BinarySearchTree<Character> bst = new BinarySearchTree<>();
        bst.insert('c');
        bst.insert('d');
        bst.insert('e');
        bst.insert('f');

        Assert.assertTrue(bst.searchRecursive('e'));
        Assert.assertFalse(bst.searchRecursive('p'));
    }


}
