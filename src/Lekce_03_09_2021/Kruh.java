package Lekce_03_09_2021;

import java.util.Scanner;

public class Kruh {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Circle radius:");
        int circleRadius = scan.nextInt();

        if (circleRadius % 2 != 0) {
            for (int i = 0; i < circleRadius; i++) {
                // nothing yet
            }
        } else {
            System.out.println("Circle radius shouldn't be even number");
        }

    }
}
