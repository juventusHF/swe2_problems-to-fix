package ch.juventus.se.problemstofix.calc;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @author: Linda Krüger
 * @since: 12.09.17
 */
public class Calculations {

    public double divide (double a, double b) {

        // Solution:
//        DecimalFormat df2 = new DecimalFormat("###.##");
//        return Double.valueOf(df2.format(a/b));

        return a/b;
    }

    public double countTotal(List<BankAccount> accounts) {
        double total = 0;
        int i = 0;

        while (i < accounts.size()) {
            i++;
            total += accounts.get(i).getBalance();
            //Solution
//            i++;
        }

        return total;
    }

    public int countErrors (List<String> data) {
        int errorCount = 0;

        // Solution
        // for (int i = 0; i < data.size(); i++) {
        for (int i = 0; i <= data.size(); i++) {
            if(data.get(i).contains("error")) {
                errorCount++;
            }
        }

        return errorCount;
    }

}
