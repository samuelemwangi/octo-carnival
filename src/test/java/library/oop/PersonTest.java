package library.oop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonTest {

    @Test
    public void testPerson() {
        String name = "Tester";
        Float years = 34F;
        Person person = new Person(name, years);

        Assert.assertEquals(person.getName(), name);
        Assert.assertEquals(person.getYears(), years);

        Assert.assertTrue(person.canWalk());
        Assert.assertTrue(person.isAdult());

        Person person2 =  new Person("Zakaria", 67F);

        Assert.assertTrue(person.compareTo(person2) < 0);
    }
}
