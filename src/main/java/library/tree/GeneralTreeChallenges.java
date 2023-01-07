package library.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class GeneralTreeChallenges<T extends Comparable<T>> {

    /***
     *
     * @param root start node
     * @return String
     * @complexity Time ->  O(n), Space -> O(n)
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
     * @complexity Time ->  O(n), Space -> O(n)
     */
    public StringBuilder dfsTraversalRecursive(Node<T> currNode, StringBuilder result) {

        if (currNode == null)
            return result;

        result.append(currNode.data).append(",");
        dfsTraversalRecursive(currNode.leftChild, result);
        dfsTraversalRecursive(currNode.rightChild, result);
        return result;
    }

    /**
     * @param root root node
     * @return string of nodes
     * @complexity Time -> O(n), Space -> O(n)
     */
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

    /***
     *
     * @param root root node
     * @param value value to search
     * @return true if found and false otherwise
     * @complexity Time -> O(n), Space -> O(n)
     */
    public boolean searchIterative(Node<T> root, T value) {
        if (root == null)
            return false;
        Queue<Node<T>> queue = new ArrayDeque<>();

        queue.offer(root);
        while (queue.peek() != null) {
            Node<T> item = queue.poll();
            if (item.data.equals(value))
                return true;
            if (item.leftChild != null)
                queue.offer(item.leftChild);
            if (item.rightChild != null)
                queue.offer(item.rightChild);
        }

        return false;
    }

    /***
     * @param currNode current node
     * @param value value to search
     * @return true if found and false otherwise
     * @complexity Time -> O(n), Space -> O(n)
     */
    public boolean searchRecursive(Node<T> currNode, T value) {
        if (currNode == null)
            return false;

        if (currNode.data.equals(value))
            return true;

        return searchRecursive(currNode.leftChild, value) || searchRecursive(currNode.rightChild, value);
    }

    /***
     *
     * @param currNode current node
     * @return sum of all nodes
     * @complexity Time -> O(n), Space -> O(n)
     */
    public int getNodesSumRecursive(Node<Integer> currNode) {
        if (currNode == null)
            return 0;

        return currNode.data +
                getNodesSumRecursive(currNode.leftChild) +
                getNodesSumRecursive(currNode.rightChild);
    }

    /***
     *
     * @param currNode current node
     * @return sum of all nodes
     * @complexity Time -> O(n), Space -> O(n)
     */
    public int findMinimumValueRecursive(Node<Integer> currNode) {
        if (currNode == null)
            return Integer.MAX_VALUE;

        int minLeft = findMinimumValueRecursive(currNode.leftChild);
        int minRight = findMinimumValueRecursive(currNode.rightChild);

        return Math.min(currNode.data, Math.min(minLeft, minRight));
    }

    public int findMinimumValueIterative(Node<Integer> currNode) {
        int minValue = Integer.MAX_VALUE;
        if (currNode == null)
            return minValue;

        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.offer(currNode);

        while (queue.peek() != null) {
            Node<Integer> item = queue.poll();
            minValue = Math.min(minValue, item.data);

            if (item.leftChild != null)
                queue.offer(item.leftChild);

            if (item.rightChild != null)
                queue.offer(item.rightChild);
        }

        return minValue;
    }

    public int maxRootToLeafPathSumRecursive(Node<Integer> currNode){
        if(currNode == null)
            return Integer.MIN_VALUE;
        if(currNode.leftChild == null && currNode.rightChild == null)
            return currNode.data;

        int leftValue =  maxRootToLeafPathSumRecursive(currNode.leftChild);
        int rightValue = maxRootToLeafPathSumRecursive(currNode.rightChild);

        return  currNode.data + Math.max(leftValue, rightValue);
    }
}
