package ch.juventus.se.problemstofix.bird;

import ch.juventus.se.problemstofix.calc.BankAccount;
import ch.juventus.se.problemstofix.calc.Calculations;
import ch.juventus.se.problemstofix.calc.InsufficientFundsException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by t372017 on 14.09.2017.
 */
public class BirdsTest {

    private BirdController birdController;
    private Bird duck;
    private Bird pigeon;
    private Bird toucan;
    private Bird turkey;

    @Before
    public void setup () {
        birdController = new BirdController();
        duck = new Duck(2, 500, true);
        pigeon = new Pigeon(1, 300, false);
        toucan = new Toucan(3, 400, true);
        turkey = new Turkey(2, 800, true);
    }

    @Test
    public void shouldAddAllBirds () {
        birdController.addBird(duck);
        birdController.addBird(pigeon);
        birdController.addBird(toucan);
        birdController.addBird(turkey);
        birdController.addBird(toucan);
        birdController.addBird(duck);
        birdController.addBird(pigeon);
        birdController.addBird(turkey);

        assertEquals("Count of birds not as expected.", 8, birdController.getBirdsCount());
    }


}
