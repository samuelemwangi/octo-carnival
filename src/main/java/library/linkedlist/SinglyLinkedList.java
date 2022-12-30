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

        while (currNode.nextNode != null) {
            if (currNode.nextNode.data.equals(data)) {
                currNode.nextNode = currNode.nextNode.nextNode;
                size--;
                return;
            }
            currNode = currNode.nextNode;
        }

    }

    public void reverse() {

        if (isEmpty())
            return;

        Node<Integer> prevNode = null;
        Node<Integer> currNode = headNode;
        Node<Integer> nextNode = null;


        while (currNode != null) {
            nextNode = currNode.nextNode;
            currNode.nextNode = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        currentTail = headNode;
        headNode = prevNode;
    }

    public void addLoop() {
        if (isEmpty())
            return;

        currentTail.nextNode = headNode;
    }

    public boolean hasLoop() {
        Node<Integer> slow = headNode;
        Node<Integer> fast = headNode;

        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            if (slow == fast)
                return true;
        }

        return false;
    }


    public Node<Integer> mergeLists(Node<Integer> list1, Node<Integer> list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Node<Integer> head = new Node<>();


        if (list1.data <= list2.data) {
            head.data = list1.data;
            list1 = list1.nextNode;
        } else {
            head.data = list2.data;
            list2 = list2.nextNode;
        }

        Node<Integer> currNode = head;

        while (list1 != null && list2 != null) {
            Node<Integer> newNode = new Node<>();
            if (list1.data <= list2.data) {
                newNode.data = list1.data;
                list1 = list1.nextNode;
            } else {
                newNode.data = list2.data;
                ;
                list2 = list2.nextNode;
            }

            currNode.nextNode = newNode;
            currNode = currNode.nextNode;
        }

        if (list1 != null) {

            while (list1 != null) {
                Node<Integer> newNode = new Node<>();
                newNode.data = list1.data;

                list1 = list1.nextNode;

                currNode.nextNode = newNode;
                currNode = currNode.nextNode;
            }

        } else {
            while (list2 != null) {
                Node<Integer> newNode = new Node<>();
                newNode.data = list2.data;

                list2 = list2.nextNode;

                currNode.nextNode = newNode;
                currNode = currNode.nextNode;
            }
        }
        return head;

    }


    public void removeNthNodeFromEnd(int target){
        if(headNode == null || target <= 0)
            return;

        int size =  0;
        Node<Integer> currNode =  headNode;

        while (currNode != null){
            size++;
            currNode = currNode.nextNode;
        }


        if(size == target){
            headNode = headNode.nextNode;
            return;
        }

        currNode =  headNode;
        Node<Integer> prevNode = null;
        int trackLength = 0;

        while(trackLength < size - target){
            trackLength++;
            prevNode = currNode;
            currNode =  currNode.nextNode;
        }

        prevNode.nextNode = currNode.nextNode;

    }

    public void printList() {
        Node<Integer> currNode = headNode;
        while (currNode != null) {
            System.out.printf(currNode.data + ", ");
            currNode = currNode.nextNode;
        }
    }

}
