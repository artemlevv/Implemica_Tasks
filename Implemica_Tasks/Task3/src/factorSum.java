import java.math.BigInteger;

/**
 * @author Artem Levchenko
 */
public class factorSum {
    /**
     * Method calculates the sum of all factorial number's digits.
     *
     * @param num integer number
     * @return sum of all factorial number's digits
     */

    public int factorial(int num) {
        final int min = 0;

        int sum = min;
        BigInteger fact = BigInteger.ONE;

        // Calculate the factorial of number
        for (int i = 2; i <= num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        String number = String.valueOf(fact);

        // Calculate sum of all digits in the number
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return sum;
    }
}

