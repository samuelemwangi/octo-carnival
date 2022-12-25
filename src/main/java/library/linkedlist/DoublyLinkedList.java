package library.linkedlist;

public class DoublyLinkedList {
    public Node<Integer> headNode;
    public int size;

    public DoublyLinkedList() {
        headNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(Integer data) {
        Node<Integer> newNode = new Node<>();
        newNode.data = data;

        if (isEmpty()) {
            headNode = newNode;
            size++;
            return;
        }

        newNode.nextNode = headNode;
        headNode.prevNode = newNode;

        headNode = newNode;
        size++;
    }

    public void insertAtEnd(Integer data) {
        Node<Integer> newNode = new Node<>();
        newNode.data = data;

        if (isEmpty()) {
            headNode = newNode;
            size++;
            return;
        }

        Node<Integer> currNode = headNode;

        while (currNode.nextNode != null) {
            currNode = currNode.nextNode;
        }

        currNode.nextNode = newNode;
        newNode.prevNode = currNode;
        size++;

    }

    public void insertAfter(Integer target, Integer data) {
        Node<Integer> newNode = new Node<>();
        newNode.data = data;

        if (isEmpty()) {
            return;
        }

        Node<Integer> currNode = headNode;
        while (currNode != null) {
            if (currNode.data.equals(target)) {
                Node<Integer> currentNextNode = currNode.nextNode;
                currNode.nextNode = newNode;
                newNode.nextNode = currentNextNode;
                newNode.prevNode = currNode;

                if (currentNextNode != null) {
                    currentNextNode.prevNode = newNode;
                }
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
        headNode.prevNode = null;
        size--;
    }

    public void deleteByValue(Integer data) {
        if (isEmpty()) {
            return;
        }

        if(headNode.data.equals(data)){
            deleteAtHead();
            return;
        }

        Node<Integer> currNode = headNode;
        while (currNode != null){
            if(currNode.data.equals(data)){
              Node<Integer> currNextNode = currNode.nextNode;
              Node<Integer> currPrevNode =  currNode.prevNode;

              currPrevNode.nextNode = currNextNode;
              if(currNextNode != null){
                  currNextNode.prevNode = currPrevNode;
              }
            }
            currNode = currNode.nextNode;
        }
        size--;
    }

    public void reverse(){
        if(isEmpty())
            return;

        Node<Integer> prevNode =  null;
        Node<Integer> currentNode = headNode;
        Node<Integer> nextNode =  null;

        while (currentNode != null){
            nextNode = currentNode.nextNode;
            prevNode = currentNode.prevNode;

            currentNode.prevNode =  nextNode;
            currentNode.nextNode = prevNode;

            prevNode =  currentNode;
            currentNode =  nextNode;
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
