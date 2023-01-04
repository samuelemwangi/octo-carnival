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
}
