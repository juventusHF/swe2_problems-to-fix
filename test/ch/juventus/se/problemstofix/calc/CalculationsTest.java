package ch.juventus.se.problemstofix.calc;

import ch.juventus.se.problemstofix.calc.Calculations;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by t372017 on 14.09.2017.
 */
public class CalculationsTest {

    private Calculations c;
    private BankAccount bankAccount;
    private List<BankAccount> accounts;
    private List<String> textData;

    @Before
    public void setup () {
        c = new Calculations();
        bankAccount = new BankAccount(100.00);
        accounts = new ArrayList<>();
        textData = new ArrayList<>();
    }

    @Test
    public void shouldDivideAndRound () {
        double result = c.divide(33, 5.2);
        assertEquals("Result of division not as expected.", 6.35, result);
    }

    @Test
    public void shouldCalculateTotalOfAllAccounts () {
        accounts.add(new BankAccount(56.00));
        accounts.add(new BankAccount(100.00));

        double total = c.countTotal(accounts);

        assertEquals("Total of all bank accounts is not correct", total, 156.00);
    }

    @Test
    public void shouldCountAllErrors () {
        textData.add("info");
        textData.add("warn");
        textData.add("error");
        textData.add("error");
        textData.add("debug");
        textData.add("info");
        textData.add("debug");
        textData.add("error");

        int errorCount = c.countErrors(textData);

        assertEquals("Error count not correct!", errorCount, 3);
    }

    @Test(expected = InsufficientFundsException.class)
    public void shouldThrowInsufficientFundsException () throws InsufficientFundsException{
        bankAccount.withdraw(160.00);
    }

    @Test
    public void shouldExponentiate () {
        Double result = c.exponentiate(new Double(2), 2);
        assertEquals(new Double(4), result);
    }

    @Test
    public void shouldReturnZero () {
        Double result = c.exponentiate(null, 2);
        assertEquals(0, result);
    }

}
