package ch.juventus.se.problemstofix.calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculationsTest {

    private Calculations c;
    private BankAccount bankAccount;
    private List<BankAccount> accounts;
    private List<String> textData;

    @BeforeEach
    public void setup () {
        c = new Calculations();
        bankAccount = new BankAccount(100.00);
        accounts = new ArrayList<>();
        textData = new ArrayList<>();
    }

    @Test
    public void shouldDivideAndRound () {
        // when
        double result = c.divide(33, 5.2);

        // then
        assertEquals(6.35, result, "Result of division not as expected.");
    }

    @Test
    public void shouldCalculateTotalOfAllAccounts () {
        // given
        accounts.add(new BankAccount(56.00));
        accounts.add(new BankAccount(100.00));

        // when
        double total = c.countTotal(accounts);

        // then
        assertEquals(156.00, total, "Total of all bank accounts is not correct");
    }

    @Test
    public void shouldCountAllErrors () {
        // given
        textData.add("info");
        textData.add("warn");
        textData.add("error");
        textData.add("error");
        textData.add("debug");
        textData.add("info");
        textData.add("debug");
        textData.add("error");

        // when
        int errorCount = c.countErrors(textData);

        // then
        assertEquals(3, errorCount, "Error count not correct!");
    }

    @Test()
    public void shouldThrowInsufficientFundsException () {
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(160.00));
    }

    @Test
    public void shouldDoExponentiation() {
        // when
        Double result = c.exponential(2d, 2);

        // then
        assertEquals(4d, result);
    }

    @Test
    public void shouldReturnZero () {
        // when
        Double result = c.exponential(null, 2);

        // then
        assertEquals(0d, result);
    }

}
