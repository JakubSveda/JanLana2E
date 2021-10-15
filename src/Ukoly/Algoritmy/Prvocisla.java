package Ukoly.Algoritmy;

import java.util.ArrayList;

public class Prvocisla {
    public static void main(String[] args) {
        System.out.println("NSD: " + getNejvetsiSpolecnyDelitel(285, 120));
        System.out.println("NSD lepe: " + getNejvetsiSpolecnyDelitelLepe(285, 120));
        System.out.println("NSD nejlepe: " + getNejvetsiSpolecnyDelitelNejlepe(285, 120));

        System.out.println();

        System.out.println("nsn: " + getNejmensiSpolecnyNasobek(23, 2));

        System.out.println();

        System.out.println("Je prvocislo? " + isPrvocislo(23));

        System.out.println();

        //int odmocneneCislo = 2;
        //System.out.println("Odmocnina z " + odmocneneCislo + ": " + getOdmocnina(odmocneneCislo));

        int in = 125;
        System.out.print("Prvociselny rozklad cisla " + in + ": ");
        for (int number: getPrvociselnyRozklad(in)) {
            System.out.print(" " + number + " ");
        }
    }

    private static int getNejvetsiSpolecnyDelitel(int a, int b) {
        while (a != b) {
            if (a < b) b -= a;
            else a -= b;
        }

        return a;
    }

    private static int getNejvetsiSpolecnyDelitelLepe(int a, int b) {
        int c;
        while (b != 0) {
            c = b;
            b = a % b;
            a = c;
        }

        return a;
    }

    private static int getNejvetsiSpolecnyDelitelNejlepe(int a, int b) {
        if (b == 0) return a;
        return getNejvetsiSpolecnyDelitelNejlepe(b, a % b);
    }

    private static int getNejmensiSpolecnyNasobek(int a, int b) {
        return ((a * b) / getNejvetsiSpolecnyDelitelNejlepe(a, b));
    }

    private static boolean isPrvocislo(int a) {
        if (a % 2 == 0) return (a == 2);
        int counter = 3;
        while (counter * counter <= a) {
            if (a % counter == 0) return false;
            else counter++;
        }

        return true;
    }

    /*
    private static double getOdmocnina(double a) {
        double x = a / 2;
        for (int i = 0; i < 100; i++) {
            x = 0.5 * (x + (a / 2));
        }

        return x;
    }
     */

    private static ArrayList<Integer> getPrvociselnyRozklad(int a) {
        ArrayList<Integer> list = new ArrayList<>();
        int counter = 2;

        while (a > 1) {
            if (a % counter == 0) {
                list.add(counter);
                a /= counter;
            } else counter++;
        }

        return list;
    }
}
