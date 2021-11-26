package Ukoly.Algoritmy;

import java.util.Arrays;

public class VelkaCisla {
    public static void main(String[] args) {
        // x = 54 + 1116
        int[] soucet = scitani(new int[] {4, 5}, new int[] {6, 1, 1, 1});
        for (int j : soucet) {
            System.out.print(j);
        }
    }

    private static int[] scitani(int[] firstNumbers, int[] secondNumbers) {
        int firstCifry = firstNumbers.length;
        int secondCifry = secondNumbers.length;
        int min = Math.min(firstCifry, secondCifry);
        int[] result = new int[min + 1];
        Arrays.fill(result, 0);
        int prenos = 0;

        for (int i = 0; i < min; i++) {
            int soucetCifer = firstNumbers[i] + secondNumbers[i];
            result[i] = soucetCifer % 10;
            result[i] += prenos;
            System.out.println(result[i]);
            prenos = soucetCifer / 10;
        }

        if (prenos != 0) {
            result[result.length-1] = prenos;
        }

        if (firstCifry != secondCifry) {
            for (int i = min - 1; i < Math.max(firstCifry, secondCifry) - 1; i++) {
                result[i] += (firstCifry > secondCifry) ? firstNumbers[i] : secondNumbers[i];
            }
        }

        return result;
    }
}
