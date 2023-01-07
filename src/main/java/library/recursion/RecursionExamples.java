package library.recursion;


import library.linkedlist.Node;
import library.oop.Person;


public class RecursionExamples {

    /***
     *
     * @param person
     * @return total count
     *  Time complexity -  O(n) -> n is number of nodes in the list
     *  Space complexity - O(n) -> we make n stack calls
     */
    public int atmCountQueue(Node<Person> person) {
        // base case
        // end of the list is zero
        if (person == null)
            return 0;
        return 1 + atmCountQueue(person.nextNode);
    }

    /***
     *
     * @param str
     * @return the reversed string
     * Time complexity -  O(n) -> n is the number of characters in the string
     * Space complexity - O(n) -> we make n stack calls
     */
    public String reverseString(String str) {
        // base case
        if (str == null)
            return null;

        // base case - one character is already reversed
        if (str.length() == 1)
            return str;

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    /***
     *
     * @param str
     * @return if string is palindrome
     * Time complexity - 0(n) -> n is the number of characters in the string
     * Space complexity - O(n) -> we make n/2 stack calls
     */
    public boolean stringIsPalindrome(String str) {
        // base case
        if (str.length() == 0 || str.length() == 1)
            return true;

        if (str.charAt(0) == str.charAt(str.length() - 1))
            return stringIsPalindrome(str.substring(1, str.length() - 1));

        // base case for no match
        return false;
    }

    public String decimalToBinary(int num) {
        return decimalToBinary(num, "");
    }

    /***
     *
     * @param num
     * @param result
     * @return binary string
     * Time complexity - O(log n) -> we halve the number every time
     * Space complexity - O(log n) -> we make log n stack calls
     */
    public String decimalToBinary(int num, String result) {
        if (num == 0) {
            return result;
        }

        result = num % 2 + result;
        return decimalToBinary(num / 2, result);
    }

    /***
     *
     * @param num
     * @return natural sum
     * Time complexity -  O(n) -> n equals provided number
     * Space complexity - O(n) -> we make maximum n stack calls
     */
    public int numberSummation(int num) {
        if (num <= 1)
            return num;

        return num + numberSummation(num - 1);
    }

    public boolean binarySearch(int[] arr, int value) {
        return binarySearch(arr, 0, arr.length -1, value);
    }


    /***
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return true if found and false otherwise
     * Time complexity - O(log n) -> we halve the length every time
     * Space complexity - O(log n) -> we make log n stack calls
     */
    public boolean binarySearch(int[] arr, int left, int right, int value) {
        // base case for failure
        if (left > right)
            return false;

        int mid = (left + right) / 2;

        // base case for a match
        if (value == arr[mid]) {
            return true;
        }

        if (value > arr[mid])
            return binarySearch(arr, mid + 1, right, value);

        return binarySearch(arr, left, mid - 1, value);

    }

    /***
     *
     * @param num
     * @return fb of a num
     * Time complexity - O(2^n) -> every call on i in n makes 2 fn calls
     * Space complexity - O(2^n) -> every fn call makes 2 fn calls
     */
    public int basicFib(int num){
        if(num == 0 || num == 1)
            return num;

        return basicFib(num-1) + basicFib(num-2);
    }

}
