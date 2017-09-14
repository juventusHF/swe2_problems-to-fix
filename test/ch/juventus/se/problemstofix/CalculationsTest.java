package ch.juventus.se.problemstofix;

import ch.juventus.se.problemstofix.Calculations;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by t372017 on 14.09.2017.
 */
public class CalculationsTest {

    private Calculations c;

    @Before
    public void setup () {
        c = new Calculations();
    }

    @Test
    public void shouldDivideAndRound () {
        double result = c.divide(33, 5.2);
        assertEquals("Result of division not as expected.", 6.35, result);
    }

}
