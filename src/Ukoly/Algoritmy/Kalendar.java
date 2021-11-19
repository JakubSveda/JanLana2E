package Ukoly.Algoritmy;

import java.util.Arrays;

public class Kalendar {
    private static int[] mesice = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        System.out.println(isPrestupny(2001));
        System.out.println(Arrays.toString(getVcera(new int[] {1, 2, 2000})));
        System.out.println(pocetDniMezi(new int[] {1, 1, 2000}, new int[] {3, 1, 2000}));
    }


    private static boolean isPrestupny(int r) {
        if (r % 100 == 0) return r % 400 == 0;
        else return r % 4 == 0;
    }

    private static int[] getVcera(int[] datum) {
        if (isPrestupny(datum[2])) mesice[2] = 29;
        if (datum[0] > 1) {
            datum[0] -= 1;
        } else if (datum[1] == 1) {
            datum[0] = 31;
            datum[1] = 12;
            datum[2] -= 1;
        } else {
            datum[0] = mesice[datum[1] - 1];
            datum[1] -= 1;
        }

        return datum;
    }

    private static int pocetDniMezi(int [] datum1, int [] datum2) {
        if (isPrestupny(datum1[2])) mesice[2] = 29;
        int counter = 0;
        while (!Arrays.equals(datum1, datum2)) {
            counter++;
            getVcera(datum2);
        }

        return counter;
    }
}
