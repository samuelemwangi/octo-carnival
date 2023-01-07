package library.recursion;

import library.linkedlist.SinglyLinkedList;
import library.oop.Person;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class RecursionExamplesTest {

    @Test
    public void testCountMembersInATMQueue() {
        SinglyLinkedList<Person> persons = new SinglyLinkedList<>();
        persons.insertAtEnd(new Person("James", 35F));
        persons.insertAtEnd(new Person("Mwangi", 15F));
        persons.insertAtEnd(new Person("Main Tester", 25F));

        RecursionExamples recursionExamples = new RecursionExamples();

        Assert.assertEquals(recursionExamples.atmCountQueue(persons.headNode), 3);
    }

    @Test
    public void testReverseString() {
        String sample1 = "12345";
        String reversedSample1 = "54321";

        String sample2 = "sd";
        String reversedSample2 = "ds";

        String sample3 = "G";
        String reversedSample3 = "G";

        RecursionExamples recursionExample = new RecursionExamples();

        Assert.assertEquals(recursionExample.reverseString(sample1), reversedSample1);
        Assert.assertEquals(recursionExample.reverseString(sample2), reversedSample2);
        Assert.assertEquals(recursionExample.reverseString(sample3), reversedSample3);
    }

    @Test
    public void testStringIsPalindrome() {
        String sample = "kayak";
        RecursionExamples recursionExample = new RecursionExamples();
        Assert.assertTrue(recursionExample.stringIsPalindrome(sample));
    }

    @Test
    public void testDecimalToBinary() {
        int sample1 = 2;
        String binSample1 = "10";

        int sample2 = 233;
        String binSample2 = "11101001";

        RecursionExamples recursionExample = new RecursionExamples();

        Assert.assertEquals(recursionExample.decimalToBinary(sample1), binSample1);
        Assert.assertEquals(recursionExample.decimalToBinary(sample2), binSample2);
    }

    @Test
    public void testNumberSummation() {
        int sample1 = 5;
        int sample2 = 10;
        RecursionExamples recursionExample = new RecursionExamples();

        Assert.assertEquals(recursionExample.numberSummation(sample1), 15);
        Assert.assertEquals(recursionExample.numberSummation(sample2), 55);
    }

    @Test
    public void testBinarySearch() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        RecursionExamples recursionExamples = new RecursionExamples();
        Assert.assertTrue(recursionExamples.binarySearch(arr, 2));
        Assert.assertFalse(recursionExamples.binarySearch(arr, 19));
        Assert.assertFalse(recursionExamples.binarySearch(arr, -1));
    }


    @Test(dataProvider = "nums")
    public void testBasicFib(int num) {
        RecursionExamples recursionExamples = new RecursionExamples();


        int prevPrev = 0;
        int prev = 1;

        for (int j = 2; j <= num; j++) {
            int result = prev + prevPrev;
            prevPrev = prev;
            prev = result;
        }

        Assert.assertEquals(recursionExamples.basicFib(num), prev);

    }

    @DataProvider(name = "nums")
    private static Object[][] getNums() {
        return new Object[][]{
                {2},
                {3},
                {5}
        };
    }
}
