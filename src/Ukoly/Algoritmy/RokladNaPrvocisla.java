package Ukoly.Algoritmy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RokladNaPrvocisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();


        System.out.print(input + " =");

        for (int prvekRozkladu : getPrvociselnyRozkladList(input)) {
            System.out.print(" " + prvekRozkladu);
        }

        System.out.println(";");


        //printPrvociselnyRozklad(input);
    }

    private static ArrayList<Integer> getPrvociselnyRozkladList(int vstupniCislo) {
        ArrayList<Integer> prvociselnyRozklad = new ArrayList<>();
        boolean[] prvocislaDoVstupnihoCisla = new boolean[vstupniCislo];
        Arrays.fill(prvocislaDoVstupnihoCisla, true);
        int zbytek = vstupniCislo;

        for (int index = 2; index < vstupniCislo; index++) {
            if (prvocislaDoVstupnihoCisla[index]) {
                while (zbytek % index == 0) {
                    prvociselnyRozklad.add(index);
                    zbytek /= index;
                }
                if (zbytek == 1) return prvociselnyRozklad;

                int counter = 2 * index;
                while (counter < vstupniCislo) {
                    prvocislaDoVstupnihoCisla[counter] = false;
                    counter += index;
                }
            }
        }

        prvociselnyRozklad.add(vstupniCislo);
        return prvociselnyRozklad;
    }

    private static void printPrvociselnyRozklad(int vstupniCislo) {
        System.out.print(vstupniCislo + "=");
        int number = 2;
        int counter = 0;
        boolean slo = false;

        while (vstupniCislo > 1) {
            if (vstupniCislo % number == 0) {
                vstupniCislo /= number;
                counter += 1;
                slo = true;
            } else {
                if (slo) {
                    System.out.print(" " + number + ((counter > 1) ? ("^" + counter) : ""));
                    counter = 0;
                    slo = false;
                }
                number++;
            }
        }
    }
}
