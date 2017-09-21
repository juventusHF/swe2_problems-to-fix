package ch.juventus.se.problemstofix.person;

import ch.juventus.se.problemstofix.person.Address;
import ch.juventus.se.problemstofix.person.Person;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by t372017 on 14.09.2017.
 */
public class PersonTest {

    private Person person;
    private SimpleDateFormat dateFormat;

    @Before
    public void setup () {

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "1990-11-26";
        Date birthday = null;
        try {
            birthday = dateFormat.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        Address address = new Address("Rötelsteig", 10, 8037, "Zürich", "CH");

        person = new Person("Hans", "Muster", birthday, address, 7896.50, Person.Sex.MALE, true);
    }

    @Test
    public void shouldDivideAndRound () {
        String expectedOutput = "Person{firstName='Hans', lastName='Muster', birthday=Mon Nov 26 00:00:00 CET 1990, address=Address{street='Rötelsteig', houseNr=10, plz=8037, city='Zürich', country='CH'}, balance=7896.5, sex=MALE, hasKids=true}";
        assertEquals("Return of toString not as expected.", expectedOutput, person.toString());
    }
}
