package ch.juventus.se.problemstofix;

import ch.juventus.se.problemstofix.Person;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by t372017 on 14.09.2017.
 */
public class PersonTest {

    private Person person;

    @Before
    public void setup () {
        person = new Person("Hans", "Muster", );
    }

    @Test
    public void shouldDivideAndRound () {
        double result = c.divide(33, 5.2);
        assertEquals("Result of division not as expected.", 6.35, result);
    }
}
