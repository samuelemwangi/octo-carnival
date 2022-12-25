package library.linkedlist;

public class SinglyLinkedList {
    public Node<Integer> headNode;
    public Node<Integer> currentTail;
    public int size;

    public SinglyLinkedList() {
        headNode = null;
        currentTail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(Integer data) {
        Node<Integer> newNode = new Node<>();
        newNode.data = data;
        newNode.nextNode = headNode;

        currentTail = headNode;
        headNode = newNode;

        size++;
    }

    public void insertAtEnd(Integer data) {
        Node<Integer> newNode = new Node<>();
        newNode.data = data;
        if (isEmpty()) {
            headNode = newNode;
            currentTail = headNode;
            return;
        }
        currentTail.nextNode = newNode;
        currentTail = currentTail.nextNode;
        size++;
    }

    public void insertAfter(Integer targetData, Integer data) {
        Node<Integer> newNode = new Node<>();
        newNode.data = data;

        Node<Integer> currNode = headNode;

        while (currNode != null) {
            if (currNode.data.equals(targetData)) {
                newNode.nextNode = currNode.nextNode;
                currNode.nextNode = newNode;
                return;
            }

            currNode = currNode.nextNode;
        }
        size++;
    }

    public boolean searchNode(Integer data) {
        Node<Integer> currNode = headNode;
        while (currNode != null) {
            if (currNode.data.equals(data)) {
                return true;
            }
            currNode = currNode.nextNode;
        }

        return false;
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }

        headNode = headNode.nextNode;

        size--;
    }

    public void deleteByValue(Integer data) {
        if (isEmpty()) {
            return;
        }

        if (headNode.data.equals(data)) {
            deleteAtHead();
            return;
        }

        Node<Integer> currNode = headNode;

        while (currNode.nextNode != null){
            if(currNode.nextNode.data.equals(data)){
                currNode.nextNode = currNode.nextNode.nextNode;
                size--;
                return;
            }
            currNode = currNode.nextNode;
        }

    }

    public void reverse(){

        if(isEmpty())
            return;

        Node<Integer> prevNode =  null;
        Node<Integer> currNode =  headNode;
        Node<Integer> nextNode =  null;


        while (currNode != null){
            nextNode = currNode.nextNode;
            currNode.nextNode =  prevNode;

            prevNode =  currNode;
            currNode =  nextNode;
        }

        headNode = prevNode;
    }

    public void printList() {
        Node<Integer> currNode = headNode;
        while (currNode != null) {
            System.out.printf(currNode.data + ", ");
            currNode = currNode.nextNode;
        }
    }

}
