package library.linkedlist;

public class DoublyLinkedList<T extends Comparable<T>> {
    public Node<T> headNode;
    public int size;

    public DoublyLinkedList() {
        headNode = null;
        size = 0;
    }


    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>();
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

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (isEmpty()) {
            headNode = newNode;
            size++;
            return;
        }

        Node<T> currNode = headNode;

        while (currNode.nextNode != null) {
            currNode = currNode.nextNode;
        }

        currNode.nextNode = newNode;
        newNode.prevNode = currNode;
        size++;

    }

    public void insertAfter(T target, T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (isEmpty()) {
            return;
        }

        Node<T> currNode = headNode;
        while (currNode != null) {
            if (currNode.data.equals(target)) {
                Node<T> currentNextNode = currNode.nextNode;
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

    public boolean searchNode(T data) {
        Node<T> currNode = headNode;

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

    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }

        if(headNode.data.equals(data)){
            deleteAtHead();
            return;
        }

        Node<T> currNode = headNode;
        while (currNode != null){
            if(currNode.data.equals(data)){
              Node<T> currNextNode = currNode.nextNode;
              Node<T> currPrevNode =  currNode.prevNode;

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

        Node<T> prevNode =  null;
        Node<T> currentNode = headNode;
        Node<T> nextNode =  null;

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

    public void addLoop(){
        if(isEmpty())
            return;

        Node<T> currNode =  headNode;

        while (currNode.nextNode != null){
            currNode =  currNode.nextNode;
        }

        currNode.nextNode = headNode;
    }

    public boolean hasLoop(){

        Node<T> slow = headNode;
        Node<T> fast =  headNode;

        while (slow != null && fast != null && fast.nextNode != null){
            slow =  slow.nextNode;
            fast = fast.nextNode.nextNode;
            if(slow == fast)
                return true;
        }

        return false;

    }

    public Node<T> mergeLists(Node<T> list1, Node<T> list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        Node<T> head = new Node<>();
        
        if(list1.data.compareTo(list2.data) <= 0){
            head.data =  list1.data;
            list1 = list1.nextNode;
        }else{
            head.data = list2.data;
            list2 = list2.nextNode;
        }

        Node<T> currNode = head;

        while (list1 != null && list2 != null){
            Node<T> newNode =  new Node<>();
            if(list1.data.compareTo(list2.data) <= 0){
                newNode.data = list1.data;
                list1 = list1.nextNode;
            }else{
                newNode.data = list2.data;
                list2 = list2.nextNode;
            }
            currNode.nextNode = newNode;
            newNode.prevNode = currNode;

            currNode = currNode.nextNode;
        }

        if(list1 != null){
            currNode.nextNode = list1;
            list1.prevNode = currNode;
        }

        if(list2 != null){
            currNode.nextNode = list2;
            list2.prevNode = currNode;
        }
        return head;
    }

    public void removeNthNodeFromEnd(int target){
        if(headNode == null || target <= 0)
            return;

        Node<T> currNode =  headNode;
        int size = 0;
        while (currNode != null){
            size++;
            currNode = currNode.nextNode;
        }

        if(size == target){
            headNode = headNode.nextNode;
            headNode.prevNode = null;
            return;
        }

        currNode =  headNode;
        Node<T> prevNode =  null;
        int trackLength = 0;

        while (trackLength < size - target){
            trackLength++;
            prevNode =  currNode;
            currNode = currNode.nextNode;
        }

        prevNode.nextNode =  currNode.nextNode;

        if(prevNode.nextNode != null){
            prevNode.nextNode.prevNode = prevNode;
        }

    }


    public void printList() {
        Node<T> currNode = headNode;
        while (currNode != null) {
            System.out.printf(currNode.data + ", ");
            currNode = currNode.nextNode;
        }
    }
}
