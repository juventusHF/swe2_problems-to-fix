package ch.juventus.se.problemstofix.person;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by t372017 on 14.09.2017.
 */
public class PersonTest {

    private Person p1;
    private Person p2;
    private PersonMapper personMapper;
    private SimpleDateFormat dateFormat;

    @Before
    public void setup () {

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
        assertEquals("Address is not equals", p1.getAddress(), student.getAddress());
        assertEquals("Birthday is not equals", p1.getBirthday(), student.getBirthday());
    }
}
