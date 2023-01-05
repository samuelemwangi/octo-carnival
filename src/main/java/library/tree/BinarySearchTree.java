package library.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    public Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node<T> currNode = root;

        while (currNode != null) {
            Node<T> leftChild = currNode.leftChild;
            Node<T> rightChild = currNode.rightChild;

            if (currNode.data.compareTo(value) >= 0) {
                if (leftChild == null) {
                    currNode.leftChild = newNode;
                    return;
                }
                currNode = currNode.leftChild;

            } else {

                if (rightChild == null) {
                    currNode.rightChild = newNode;
                    return;
                }
                currNode = currNode.rightChild;
            }
        }
    }

    public void insertRecursive(T value) {
        this.root = insertRecursive(value, root);
    }

    public Node<T> insertRecursive(T value, Node<T> currNode) {
        if (currNode == null)
            return new Node<>(value);

        if (currNode.data.compareTo(value) > 0) {
            currNode.leftChild = insertRecursive(value, currNode.leftChild);
        } else if (currNode.data.compareTo(value) < 0) {
            currNode.rightChild = insertRecursive(value, currNode.rightChild);
        } else {
            return currNode;
        }
        return currNode;
    }

    public boolean searchIterative(T value) {
        Node<T> currNode = this.root;

        if (currNode == null)
            return false;

        while (currNode != null) {
            if (currNode.data.equals(value)) {
                return true;
            } else if (currNode.data.compareTo(value) > 0) {
                currNode = currNode.leftChild;
            } else {
                currNode = currNode.rightChild;
            }
        }

        return false;
    }

    public boolean searchRecursive(T value) {
        return searchRecursive(value, this.root);
    }

    public boolean searchRecursive(T value, Node<T> currNode) {
        if (currNode == null)
            return false;

        if (currNode.data.equals(value))
            return true;

        if (currNode.data.compareTo(value) > 0) {
            return searchRecursive(value, currNode.leftChild);
        } else {
            return searchRecursive(value, currNode.rightChild);
        }
    }

    public void deleteNode(T value) {

        Node<T> currNode = this.root;
        if (currNode == null)
            return;

        // find node
        Node<T> parentNode = null;

        while (currNode != null && !currNode.data.equals(value)) {
            parentNode = currNode;
            if (currNode.data.compareTo(value) > 0) {
                currNode = currNode.leftChild;
            } else {
                currNode = currNode.rightChild;
            }
        }

        if (currNode == null)
            return;

        // handle leaf node
        if (currNode.leftChild == null && currNode.rightChild == null) {
            // root
            if (parentNode.data.equals(currNode.data)) {
                this.root = null;
                return;
            }

            if(parentNode.data.compareTo(currNode.data) > 0){
                parentNode.leftChild = null;
            }else {
                parentNode.rightChild = null;
            }
            return;
        }

        if(currNode.rightChild == null){
            if(root.data.equals(currNode.data)){
                this.root = currNode.leftChild;
                return;
            }

            if(parentNode.data.compareTo(currNode.data) > 0){
                // Assuming left side of the bst
                parentNode.leftChild =  currNode.leftChild;
            }else{
                // Assuming right side of the subtree
                parentNode.rightChild = currNode.leftChild;
            }
            return;
        }

        if(currNode.leftChild ==  null){
            if(root.data.equals(currNode.data)){
                this.root = currNode.rightChild;
                return;
            }

            if(parentNode.data.compareTo(currNode.data) > 0){
                parentNode.leftChild = currNode.rightChild;
            }else{
                 parentNode.rightChild =  currNode.rightChild;
            }
            return;
        }

        Node<T> leastNode =  findLeastNode(currNode);
        T temp =  leastNode.data;
        deleteNode(temp);
        currNode.data = temp;
    }

    private Node<T> findLeastNode(Node<T> currNode) {
        Node<T> leatNode = currNode;

        while (leatNode.leftChild != null) {
            leatNode = leatNode.leftChild;
        }
        return leatNode;
    }
}
