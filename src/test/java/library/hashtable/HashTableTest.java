package library.hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HashTableTest {

    @Test
    public void testInsert() {
        HashTable<Integer, Integer> hashTable = new HashTable<>(3);
        hashTable.insert(1, 2);
        hashTable.insert(2, 5);
        hashTable.insert(6,23);
        hashTable.insert(5,78);
        Assert.assertEquals(hashTable.size(), 4);
    }

    @Test
    public void testInsertWithStrings() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.insert("hello", "hello");
        hashTable.insert("world", "world");
        hashTable.insert("test123", "123JK");

        Assert.assertEquals(hashTable.size(), 3);
    }

    @Test
    public void testGetValue() {
        HashTable<Integer, Integer> hashTable = new HashTable<>(3);
        hashTable.insert(1, 2);
        hashTable.insert(2, 5);
        hashTable.insert(3, 7);
        hashTable.insert(4, 6);
        Assert.assertEquals(hashTable.getValue(4), 6);
        Assert.assertNull(hashTable.getValue(14));
    }

    @Test
    public void testGetValueWithStrings() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.insert("hello", "hello");
        hashTable.insert("world", "world");
        hashTable.insert("test123", "123JK");


        Assert.assertEquals(hashTable.getValue("test123"), "123JK");
        Assert.assertNull(hashTable.getValue("14"));
    }
}
