package library.oop;

import java.nio.charset.Charset;
import java.util.Random;

public class Person implements Comparable<Person>, Animal  {
    private final String name;
    private final Float years;
    private final String ticketNumber;

    public Person(String name, Float years) {
        this.name = name;
        this.years =  years;
        this.ticketNumber = generateRandomString();
    }

    public String getName(){
        return this.name;
    }

    public Float getYears(){
        return this.years;
    }

    public String getTicketNumber(){
        return this.ticketNumber;
    }

    public boolean isAdult(){
        return this.years >= 18;
    }

    private String generateRandomString(){
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        return new String(array, Charset.defaultCharset());
    }


    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

    @Override
    public int legs() {
        return 2;
    }

    @Override
    public boolean canWalk() {
        return true;
    }
}
