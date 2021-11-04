package Ukoly.Algoritmy;

import java.util.Arrays;

public class ZpracovaniDatVPoli  {
    public static void main(String[] args) {
        //System.out.println(vyhodnotPolynom(2, new int[]{40, -11, 1}) + "\n");
        //System.out.println(indexOf(1, new int[]{2, 3, 4, 5, 6, 8, 1, 2, 3}) + "\n");
        //System.out.println(indexOfLepe(1, new int[]{1, 3, 4, 5, 6, 8, 1, 2, 3}) + "\n");
        //System.out.println(indexOfBinarniVyhledavani(4, new int[]{1, 2, 5, 7, 9, 56, 2, 4, 9, 5}) + "\n");
        //System.out.println(Arrays.toString(moveIndexByOneForward(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(moveIndexByOneBackwards(new int[]{1, 2, 3, 4, 5})));
    }

    private static double vyhodnotPolynom(int vstupniCisloPolynomu, int[] koeficientyPodleMocnin) {
        double result = 0;
        for (int i = koeficientyPodleMocnin.length - 1; i >= 0; i--) {
            result = result * vstupniCisloPolynomu + koeficientyPodleMocnin[i];
        }

        return result;
    }

    private static int indexOf(int hledaneCislo, int[] poleProHledani) {
        for (int i = 0; i < poleProHledani.length; i++) {
            if (poleProHledani[i] == hledaneCislo) {
                return i;
            }
        }

        return -1;
    }

    private static int indexOfLepe(int hledaneCislo, int[] poleProHledani) {
        int index = 0;
        while (index < poleProHledani.length && poleProHledani[index] != hledaneCislo) index++;
        return index;
    }

    private static int indexOfSeZarazkou(int hledaneCislo, int[] poleProHledani) {
        int i = 0;

        do {
            int lastIndex = poleProHledani.length - 1;
            int posledni = poleProHledani[lastIndex];

            if (posledni == hledaneCislo)
                return lastIndex;

            poleProHledani[poleProHledani.length-1] = hledaneCislo;
        } while (poleProHledani[i] != hledaneCislo);{
            i++;
        }

        return i;
    }

    private static int indexOfBinarniVyhledavani(int hledaneCislo, int[] poleProHledani) {
        Arrays.sort(poleProHledani);

        int leveUkazovatko = 0;
        int praveUkazovatko = poleProHledani.length - 1;
        int stredPole = (leveUkazovatko + praveUkazovatko) / 2;
        while(leveUkazovatko < praveUkazovatko && poleProHledani[stredPole] != hledaneCislo) {
            if (hledaneCislo < poleProHledani[stredPole])
                praveUkazovatko = stredPole - 1;
            else
                leveUkazovatko = stredPole + 1;

            stredPole = (leveUkazovatko + praveUkazovatko) / 2;
        }

        return stredPole;
    }

    private static int[] moveIndexByOneForward(int[] arr) {
        int last = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }

        arr[0] = last;
        return arr;
    }

    private static int[] moveIndexByOneBackwards(int [] arr) {
        int first = arr[0];

        for (int i = 0; i <= (arr.length - 2); i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = first;
        return arr;
    }
}
