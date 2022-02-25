package Lekce_2022_02_11;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EratostenovoSitoProNejvetsi {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(eratostenovoSitoJinak(1000000)));
        eratostenovoSitoJinak(100000000);
    }

    private static boolean[] eratostenovoSito(int konecIntervalu) {
        boolean[] prvocisla = new boolean[konecIntervalu + 1];
        for (int i = 0; i < prvocisla.length; i++) {
            prvocisla[i] = true;
        }

        int pocitadlo = 2;
        while (pocitadlo * pocitadlo <= konecIntervalu) {
            if (prvocisla[pocitadlo]) {
                int i = 2 * pocitadlo;
                while (i <= konecIntervalu) {
                    prvocisla[i] = false;
                    i += pocitadlo;
                }
            }
            pocitadlo++;
        }

        return prvocisla;
    }

    private static byte[] eratostenovoSitoJinak(int konecIntervalu) {
        byte[] arr = new byte[konecIntervalu + 1];

        System.out.println(2);
        for (int i = 0; i < arr.length; i++) {
            if  (arr[i] == 0) {
                int x = i*2 + 1;
                System.out.println(x);

                for (int j = i; j < arr.length; j += x/2) {
                    arr[j] = 1;
                }
            }
        }

        return arr;
    }
}
