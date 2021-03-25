package ch.juventus.se.problemstofix.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PersonTest {

    private Person p1;
    private Person p2;
    private PersonController personController;
    private PersonMapper personMapper;

    @BeforeEach
    public void setup () {

        personController = new PersonController();
        personMapper = new PersonMapper();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
        // given
        String expectedOutput = "Person{firstName='Hans', lastName='Muster', birthday=Mon Nov 26 00:00:00 CET 1990, address=Address{street='Rötelsteig', houseNr=10, plz=8037, city='Zürich', country='CH'}, balance=7896.5, sex=MALE, hasKids=true}";

        // when
        String actualOutput = p1.toString();

        // then
        assertEquals(expectedOutput, actualOutput, "Return of toString not as expected.");
    }

    @Test
    public void personsShouldBeEquals() {
        // when
        boolean personsAreEqual = p1.equals(p2);

        // then
        assertTrue(personsAreEqual, "Persons p1 " + p1.toString() + " is not equals to p2 " + p2.toString());
    }

    @Test
    public void shouldMapPersonToStudent () {
        // when
        Student student = personMapper.mapPersonToStudent(p1);

        // then
        assertEquals(p1.getFirstName(), student.getFirstName(), "First name is not equals");
        assertEquals(p1.getLastName(), student.getLastName(), "Last name is not equals");
        assertEquals(p1.getAddress(), student.getAddress(), "City is not equals");
        assertEquals(p1.getBirthday(), student.getBirthday(), "Birthday is not equals");
    }

    @Test
    public void shouldRemoveAllLindas () {
        // given
        List<Person> people = new ArrayList<>();
        people.add(new Person("Linda", null, null, null, null, null, null));
        people.add(new Person("Andreas", null, null, null, null, null, null));
        people.add(new Person("David", null, null, null, null, null, null));
        people.add(new Person("Emanuel", null, null, null, null, null, null));
        people.add(new Person("Cyrill", null, null, null, null, null, null));
        people.add(new Person("Jonathan", null, null, null, null, null, null));
        people.add(new Person("Noel", null, null, null, null, null, null));

        // when
        List<Person> filteredList = personController.removeAllLindas(people);

        // then
        assertEquals(6, filteredList.size(), "Size of returned list is not as expected");
    }

    @Test
    public void shouldRemoveAllUnderaged () {
        // given
        List<Person> people = new ArrayList<>();
        people.add(new Person(null, null, new Date(711842400000L), null, null, null, null));
        people.add(new Person(null, null, new Date(932680800000L), null, null, null, null));
        people.add(new Person(null, null, new Date(964303200000L), null, null, null, null));
        people.add(new Person(null, null, new Date(806450400000L), null, null, null, null));
        people.add(new Person(null, null, new Date(1279756800000L), null, null, null, null));
        people.add(new Person(null, null, new Date(238460400000L), null, null, null, null));
        people.add(new Person(null, null, new Date(1248300000000L), null, null, null, null));

        // when
        List<Person> filteredList = personController.removeAllUnderage(people);

        // then
        assertEquals(5, filteredList.size(), "Size of returned list is not as expected");
    }

    @Test
    public void shouldRemoveAllWithLetterAInLastName () {
        // given
        List<Person> people = new ArrayList<>();
        people.add(new Person(null, "Krueger", null, null, null, null, null));
        people.add(new Person(null, "Frick", null, null, null, null, null));
        people.add(new Person(null, "Keller", null, null, null, null, null));
        people.add(new Person(null, "Sovrano", null, null, null, null, null));
        people.add(new Person(null, "Troxler", null, null, null, null, null));
        people.add(new Person(null, "Werren", null, null, null, null, null));
        people.add(new Person(null, "Widmer", null, null, null, null, null));

        // when
        List<Person> filteredList = personController.removeAllWitLetterAInName(people);

        // then
        assertEquals(6, filteredList.size(), "Size of returned list is not as expected");
    }
}
