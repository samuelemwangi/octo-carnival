package library.recursion;

import library.linkedlist.SinglyLinkedList;
import library.oop.Person;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AtmAnalogyTest {

    @Test
    public void testCountMembersInQueue() {
        SinglyLinkedList<Person> persons = new SinglyLinkedList<>();
        persons.insertAtEnd(new Person("James", 35F));
        persons.insertAtEnd(new Person("Mwangi", 15F));
        persons.insertAtEnd(new Person("Main Tester", 25F));

        AtmAnalogy atmAnalogy = new AtmAnalogy();

        Assert.assertEquals(atmAnalogy.countQueue(persons.headNode), 3);
    }
}
