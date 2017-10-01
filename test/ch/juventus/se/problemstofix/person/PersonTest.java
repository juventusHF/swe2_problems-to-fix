package ch.juventus.se.problemstofix.person;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by t372017 on 14.09.2017.
 */
public class PersonTest {

    private Person p1;
    private Person p2;
    private PersonController personController;
    private PersonMapper personMapper;
    private SimpleDateFormat dateFormat;

    @Before
    public void setup () {

        personController = new PersonController();
        personMapper = new PersonMapper();

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "1990-11-26";
        Date birthday = null;
        try {
            birthday = dateFormat.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        Address address = new Address("Rötelsteig", 10, 8037, "Zürich", "CH");

        p1 = new Person("Hans", "Muster", birthday, address, 7896.50, Person.Sex.MALE, true);
        p2 = new Person("Hans", "Muster", birthday, address, 7896.50, Person.Sex.MALE, true);
    }

    @Test
    public void shouldReturnCorrectString () {
        String expectedOutput = "Person{firstName='Hans', lastName='Muster', birthday=Mon Nov 26 00:00:00 CET 1990, address=Address{street='Rötelsteig', houseNr=10, plz=8037, city='Zürich', country='CH'}, balance=7896.5, sex=MALE, hasKids=true}";
        assertEquals("Return of toString not as expected.", expectedOutput, p1.toString());
    }

    @Test
    public void personsShouldBeEquals() {
        assertTrue("Persons p1 " + p1.toString() + " is not equals to p2 " + p2.toString(), p1.equals(p2));
    }

    @Test
    public void shouldMapPersonToStudent () {
        Student student = personMapper.mapPersonToStudent(p1);

        assertEquals("First name is not equals", p1.getFirstName(), student.getFirstName());
        assertEquals("Last name is not equals", p1.getLastName(), student.getLastName());
        assertEquals("City is not equals", p1.getAddress(), student.getAddress());
        assertEquals("Birthday is not equals", p1.getBirthday(), student.getBirthday());
    }

    @Test
    public void shouldRemoveAllLindas () {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Linda", null, null, null, null, null, null));
        people.add(new Person("Andreas", null, null, null, null, null, null));
        people.add(new Person("David", null, null, null, null, null, null));
        people.add(new Person("Emanuel", null, null, null, null, null, null));
        people.add(new Person("Cyrill", null, null, null, null, null, null));
        people.add(new Person("Jonathan", null, null, null, null, null, null));
        people.add(new Person("Noel", null, null, null, null, null, null));

        personController.removeAllLindas(people);

        assertEquals("Size of returned list is not as expected", people.size(), 6);
    }

    @Test
    public void shouldRemoveAllUnderaged () {
        List<Person> people = new ArrayList<>();
        people.add(new Person(null, null, new Date(711842400000l), null, null, null, null));
        people.add(new Person(null, null, new Date(932680800000l), null, null, null, null));
        people.add(new Person(null, null, new Date(964303200000l), null, null, null, null));
        people.add(new Person(null, null, new Date(806450400000l), null, null, null, null));
        people.add(new Person(null, null, new Date(1058911200000l), null, null, null, null));
        people.add(new Person(null, null, new Date(238460400000l), null, null, null, null));
        people.add(new Person(null, null, new Date(1248300000000l), null, null, null, null));

        personController.removeAllUnderage(people);

        assertEquals("Size of returned list is not as expected", 4, people.size());
    }
}
