package Ukoly.Algoritmy;

import java.util.Arrays;

public class Kalendar {
    private static int[] mesice = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        System.out.println(isPrestupny(2001));
        System.out.println(Arrays.toString(getVcera(new int[] {1, 1, 2000})));
    }


    private static boolean isPrestupny(int r) {
        if (r % 100 == 0) return r % 400 == 0;
        else return r % 4 == 0;
    }

    private static int[] getVcera(int[] datum) {
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
}
