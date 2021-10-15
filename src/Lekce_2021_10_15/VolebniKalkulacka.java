package Lekce_2021_10_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VolebniKalkulacka {
    private static int[][] arr = new int[22][14];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Lekce_2021_10_15/volby2021.txt"));
        sc.nextLine();

        for (int i = 0; i < 22; i++) {
            String jmeno = sc.next();
            System.out.print(jmeno + " ");

            for (int j = 0; j < 14; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println();
        for (int[] radek: arr) {
            System.out.println(Arrays.toString(radek));
        }

        System.out.println("\n" + volebniUcast());
        System.out.println("\n" + mandatoveCislo());

        System.out.println();
        for (int poslanecNaKraj: pocetPoslancu()) {
            System.out.print(poslanecNaKraj + " ");
        }

        /*
        System.out.println();
        int pocet = 0;
        for (int p: pocetPoslancu()) {
            pocet += p;
        }
        System.out.println(pocet);
         */

    }

    private static int volebniUcast() {
        if (arr != null) {
            int soucet = 0;

            for (int[] radek: arr) {
                for (int hlasyNaKraj: radek) {
                    soucet += hlasyNaKraj;
                }
            }

            return soucet;
        } else
            return 0;
    }

    private static int mandatoveCislo() {
        return volebniUcast() / 200;
    }

    private static int[] pocetPoslancu() {
        int[] poslanciNaKraj = new int[14];
        Arrays.fill(poslanciNaKraj, 0);

        for (int[] radek : arr) {
            for (int i = 0; i < radek.length; i++) {
                poslanciNaKraj[i] += radek[i];
            }
        }

        for (int i = 0; i < poslanciNaKraj.length; i++) {
            poslanciNaKraj[i] /= mandatoveCislo();
        }

        return poslanciNaKraj;
    }

    private static int[][] mandatyNaKraj() {
        //int[][] mandatyNaKrajArr = new int[22][14];
        ArrayList<int[]> list = new ArrayList<>();
        int minimumProcent = volebniUcast() / 20;

        for (int[] radek: arr) {
            int soucet = 0;
            for (int hlasyNaKraj: radek) {
                soucet += hlasyNaKraj;
            }

            if (soucet >= minimumProcent) list.add(radek);
        }

        int[][] mandatyNaKrajArr = new int[list.size()][14];

        // TODO

        return mandatyNaKrajArr;
    }

    private static int[] propadlehlasyNaKrajProcenta() {
        int[] propadleHlasyNaKraj = new int[14];

        ArrayList<int[]> list = new ArrayList<>();
        int minimumProcent = volebniUcast() / 20;

        for (int[] radek: arr) {
            int soucet = 0;
            for (int hlasyNaKraj: radek) {
                soucet += hlasyNaKraj;
            }

            if (soucet <= minimumProcent) list.add(radek);
        }

        // TODO

        return propadleHlasyNaKraj;
    }
}
