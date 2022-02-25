package Lekce_2022_02_25;

public class EulerovoCislo {
    public static void main(String[] args) {
        System.out.println(eulerovoCislo(1));
    }

    public static int vypocetPolynomu(int x, int[] arr) {
        int vysledek = 0;
        int prubezneX = 1;
        for (int j : arr) {
            vysledek += prubezneX * j;
            prubezneX *= x;
        }

        return vysledek;
    }

    private static double eulerovoCislo(int x) {
        double e = 1 + x;
        double faktorial = 1;
        for (int i = 2; i < 12; i++) {
            faktorial *= i;
            e += Math.pow(x, i) * (1 / faktorial);
        }

        return e;
    }
}
