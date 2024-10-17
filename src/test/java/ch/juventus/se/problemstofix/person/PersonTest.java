package ch.juventus.se.problemstofix.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
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

        Address address = new Address("Rötelsteig", 10, 8037, "Zürich", "CH");

        p1 = new Person("Hans", "Muster", LocalDate.of(1990, 11, 26), address, 7896.50, Person.Sex.MALE, true);
        p2 = new Person("Hans", "Muster", LocalDate.of(1990, 11, 26), address, 7896.50, Person.Sex.MALE, true);
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
        assertTrue(personsAreEqual, "Persons p1 " + p1 + " is not equals to p2 " + p2);
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
        people.add(new Person("Linda", null));
        people.add(new Person("Andreas", null));
        people.add(new Person("David", null));
        people.add(new Person("Emanuel", null));
        people.add(new Person("Cyrill", null));
        people.add(new Person("Jonathan", null));
        people.add(new Person("Noel", null));

        // when
        List<Person> filteredList = personController.removeAllLindas(people);

        // then
        assertEquals(6, filteredList.size(), "Size of returned list is not as expected");
    }

    @Test
    public void shouldRemoveAllUnderaged () {
        // given
        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(2020, 1, 1)));
        people.add(new Person(LocalDate.of(2015, 1, 1)));
        people.add(new Person(LocalDate.of(2010, 1, 1)));
        people.add(new Person(LocalDate.of(2005, 1, 1)));
        people.add(new Person(LocalDate.of(2000, 1, 1)));
        people.add(new Person(LocalDate.of(1995, 1, 1)));
        people.add(new Person(LocalDate.of(1990, 1, 1)));

        // when
        List<Person> filteredList = personController.removeAllUnderage(people);

        // then
        assertEquals(4, filteredList.size(), "Size of returned list is not as expected");
    }

    @Test
    public void shouldRemoveAllWithLetterAInLastName () {
        // given
        List<Person> people = new ArrayList<>();
        people.add(new Person(null, "Krueger"));
        people.add(new Person(null, "Frick"));
        people.add(new Person(null, "Keller"));
        people.add(new Person(null, "Sovrano"));
        people.add(new Person(null, "Troxler"));
        people.add(new Person(null, "Werren"));
        people.add(new Person(null, "Widmer"));

        // when
        List<Person> filteredList = personController.removeAllWitLetterAInName(people);

        // then
        assertEquals(6, filteredList.size(), "Size of returned list is not as expected");
    }
}
