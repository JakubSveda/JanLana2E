package Ukoly.Algoritmy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RokladNaPrvocisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.print(input + " =");

        for (int prvekRozkladu : getPrvocislaArray(input)) {
            System.out.print(" " + prvekRozkladu);
        }

        System.out.println(";");
    }

    private static ArrayList<Integer> getPrvocislaArray(int vstupniCislo) {
        ArrayList<Integer> prvociselnyRozklad = new ArrayList<>();
        boolean[] prvocislaDoVstupnihoCisla = new boolean[vstupniCislo];
        Arrays.fill(prvocislaDoVstupnihoCisla, true);
        int zbytek = vstupniCislo;

        for (int i = 2; i < vstupniCislo; i++) {
            if (!prvocislaDoVstupnihoCisla[i]) continue;
            else {
                while (zbytek % i == 0) {
                    prvociselnyRozklad.add(i);
                    zbytek /= i;
                }

                int counter = 2 * i;
                while (counter < vstupniCislo) {
                    prvocislaDoVstupnihoCisla[counter] = false;
                    counter += i;
                }

                if (zbytek == 1) return prvociselnyRozklad;
            }
        }

        prvociselnyRozklad.add(vstupniCislo);
        return prvociselnyRozklad;
    }
}
