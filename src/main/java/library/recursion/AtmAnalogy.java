package library.recursion;


import library.linkedlist.Node;
import library.oop.Person;


public class AtmAnalogy {
    public int countQueue(Node<Person> person) {
        if (person == null)
            return 0;
        return 1 + countQueue(person.nextNode);
    }
}
