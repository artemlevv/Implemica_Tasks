/**
 * @author Artem Levchenko
 */
public class Number {
    /**
     * Returns the number of regular bracket sequences
     *
     * @param number Not negative integer
     * @return sum - the number of correct bracket sequences
     */
    public int getRightNumber(int number) {
        final int min = 0;
        final int first = 1;

        int sum = 0;
        //Protects against entering incorrect data(negative integer)
        if(number<0)
            return 0;
        // Return the first number from the number, if the entered number is 0
        if (number == min) {
            return first;
        }

        // Calculating a number from the series
        for (int i = 0; i < number; i++) {
            sum += getRightNumber(i) * getRightNumber((number - 1) - i);
        }
        return sum;
    }
}
