package Testing;

import java.util.Random;

public class MultiplicationOrAddition {
    public static void main(String[] args) {
        int add = 0;
        int mult = 0;

        for (int j = 0; j < 1000; j++) {
            long finalAddition = 0;
            long finalMultiplication = 0;

            for (int i = 0; i < 10000; i++) {
                Random rand = new Random();
                int number = rand.nextInt(100);
                int addition;
                int multiplication;

                long startTimeMultiplication = getCurrentTime();
                multiplication = 2 * number;
                long endTimeMultiplication = getCurrentTime();

                long startTimeAddition = getCurrentTime();
                addition = number + number;
                long endTimeAddition = getCurrentTime();

                finalAddition += (endTimeAddition - startTimeAddition);
                finalMultiplication += (endTimeMultiplication - startTimeMultiplication);
            }

            for (int i = 0; i < 10000; i++) {
                Random rand = new Random();
                int number = rand.nextInt(100);
                int addition;
                int multiplication;

                long startTimeAddition = getCurrentTime();
                addition = number + number;
                long endTimeAddition = getCurrentTime();

                long startTimeMultiplication = getCurrentTime();
                multiplication = 2 * number;
                long endTimeMultiplication = getCurrentTime();

                finalAddition += (endTimeAddition - startTimeAddition);
                finalMultiplication += (endTimeMultiplication - startTimeMultiplication);
            }

            if (finalAddition > finalMultiplication) {
                mult++;
            } else {
                add++;
            }
        }

        if (add < mult) {
            System.out.println("Multiplication is faster");
        } else {
            System.out.println("Addition is faster");
        }

        System.out.println("add wins: " + add);
        System.out.println("mult wins: " + mult);
    }

    private static long getCurrentTime() {
        return System.nanoTime();
    }
}
