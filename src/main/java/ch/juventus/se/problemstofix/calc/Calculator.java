package ch.juventus.se.problemstofix.calc;

import java.util.List;


public class Calculator {

    public double divide (double a, double b) {
        return a/b;
    }

    public Double exponential(Double value, int exponent) {
        Double result = value;

        for(int i = 0; i < exponent; i++) {
            result = result * value;
        }

        return result;
    }

    public double countTotal(List<BankAccount> accounts) {
        double total = 0;
        int i = 0;

        while (i < accounts.size()) {
            i++;
            total += accounts.get(i).getBalance();
        }

        return total;
    }

    public int countErrors (List<String> data) {
        int errorCount = 0;

        for (int i = 0; i <= data.size(); i++) {
            if(data.get(i).contains("error")) {
                errorCount++;
            }
        }

        return errorCount;
    }

}
