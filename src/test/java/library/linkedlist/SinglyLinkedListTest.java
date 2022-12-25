package library.linkedlist;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SinglyLinkedListTest {
    private static final int[] expectedList = new int[]{1, 2, 3, 5, 6, 7, 8, 10};
    private static final int arrayLength = expectedList.length;


    @Test
    public void testIsEmpty() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        Assert.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testInsertAtHead() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        for (int i = arrayLength - 1; i > -1; i--) {
            linkedList.insertAtHead(expectedList[i]);
        }

        Assert.assertTrue(compareListItems(linkedList.headNode));
    }

    @Test
    public void testInsertAtEnd() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 0; i < arrayLength; i++) {
            linkedList.insertAtEnd(expectedList[i]);
        }

        Assert.assertTrue(compareListItems(linkedList.headNode));
    }

    @Test
    public void testPrintList() {

        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));

        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 0; i < arrayLength; i++) {
            linkedList.insertAtEnd(expectedList[i]);
        }

        linkedList.printList();
        Assert.assertEquals("1, 2, 3, 5, 6, 7, 8, 10,", outputStream.toString().trim());

        System.setOut(standardOut);
    }

    @Test
    public void testInsertAfter() {
        int[] updatedList = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10};
        SinglyLinkedList linkedList = new SinglyLinkedList();

        for (int i = 0; i < arrayLength; i++) {
            linkedList.insertAtEnd(expectedList[i]);
        }

        linkedList.insertAfter(3, 4);
        Assert.assertTrue(compareListItems(linkedList.headNode, updatedList));
    }

    @Test
    public void testSearchNode() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 0; i < arrayLength; i++) {
            linkedList.insertAtEnd(expectedList[i]);
        }

        Assert.assertTrue(linkedList.searchNode(5));
        Assert.assertFalse(linkedList.searchNode(90));
    }

    @Test
    public void testDeleteAtHead() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 0; i < arrayLength; i++) {
            linkedList.insertAtEnd(expectedList[i]);
        }

        int[] updatedList = new int[]{2, 3, 5, 6, 7, 8, 10};

        linkedList.deleteAtHead();

        Assert.assertTrue(compareListItems(linkedList.headNode, updatedList));

    }

    @Test
    public void testDeleteByValue() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 0; i < arrayLength; i++) {
            linkedList.insertAtEnd(expectedList[i]);
        }
        int[] updatedList = new int[]{1, 2, 3, 5, 7, 8, 10};

        linkedList.deleteByValue(6);

        Assert.assertTrue(compareListItems(linkedList.headNode, updatedList));
    }


    @Test
    public void testReverse() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 0; i < arrayLength; i++) {
            linkedList.insertAtEnd(expectedList[i]);
        }

        int[] updatedList = new int[arrayLength];

        for (int i = arrayLength - 1; i > -1; i--) {
            updatedList[i] = expectedList[arrayLength - 1 - i];
        }
        linkedList.reverse();
        Assert.assertTrue(compareListItems(linkedList.headNode, updatedList));
    }


    private boolean compareListItems(Node<Integer> headNode) {
        return compareListItems(headNode, expectedList);
    }

    private boolean compareListItems(Node<Integer> headNode, int[] targetList) {
        Node<Integer> currNode = headNode;
        int index = 0;
        while (currNode != null) {
            if (!currNode.data.equals(targetList[index])) {
                return false;
            }
            currNode = currNode.nextNode;
            index++;
        }
        return true;
    }

}
