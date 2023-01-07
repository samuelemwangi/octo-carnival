package library.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class GeneralTreeChallenges<T extends Comparable<T>> {

    /***
     *
     * @param root start node
     * @return String
     * @complexity - Time -  O(n), Space - O(n)
     */
    public String dfsTraversalIterative(Node<T> root) {
        if (root == null)
            return "";

        StringBuilder result = new StringBuilder();

        Stack<Node<T>> tracker = new Stack<>();

        tracker.push(root);

        while (!tracker.empty()) {
            Node<T> item = tracker.pop();
            result.append(item.data).append(",");

            if (item.rightChild != null)
                tracker.push(item.rightChild);

            if (item.leftChild != null)
                tracker.push(item.leftChild);

        }

        return result.toString();
    }

    public String dfsTraversalRecursive(Node<T> root) {
        return dfsTraversalRecursive(root, new StringBuilder()).toString();
    }

    /***
     *
     * @param currNode current node
     * @param result String builder
     * @return appended String builder
     * @complexity - Time -  O(n), Space - O(n)
     */
    public StringBuilder dfsTraversalRecursive(Node<T> currNode, StringBuilder result) {

        if (currNode == null)
            return result;

        result.append(currNode.data).append(",");
        dfsTraversalRecursive(currNode.leftChild, result);
        dfsTraversalRecursive(currNode.rightChild, result);
        return result;
    }

    public String bfsTraversal(Node<T> root) {
        if (root == null)
            return "";
        StringBuilder result = new StringBuilder();
        Queue<Node<T>> tracker = new ArrayDeque<>();

        tracker.offer(root);

        while (tracker.peek() != null) {
            Node<T> item = tracker.poll();
            result.append(item.data).append(",");
            if (item.leftChild != null)
                tracker.offer(item.leftChild);
            if (item.rightChild != null)
                tracker.offer(item.rightChild);
        }
        return result.toString();
    }
}
