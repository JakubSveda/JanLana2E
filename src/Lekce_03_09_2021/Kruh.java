package Lekce_03_09_2021;

import java.util.Scanner;

public class Kruh {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Circle radius:");
        int circleRadious = scan.nextInt();

        if (circleRadious % 2 != 0) {
            for (int i = 0; i < circleRadious; i++) {
                // nothing yet
            }
        } else {
            System.out.println("Circle radius shouldn't be even number");
        }

    }
}
