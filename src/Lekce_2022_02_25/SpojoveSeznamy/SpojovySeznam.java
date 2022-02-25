package Lekce_2022_02_25.SpojoveSeznamy;

import java.util.Scanner;

public class SpojovySeznam {
    private static int cisloPrvku;

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 123;

        Prvek ap = new Prvek(a);
        Prvek bp = new Prvek(b, ap);
        Prvek cp = new Prvek(c, bp);
        //......

        Prvek aap = new Prvek(a);
        aap = new Prvek(b);
        aap = new Prvek(c);

        Scanner scanner = new Scanner(System.in);
        Prvek spojovySeznam;

        int cisloPrvku = scanner.nextInt();
        if (cisloPrvku != 0) {
            spojovySeznam = new Prvek(cisloPrvku,  null);

            while (true) {
                int cislo = scanner.nextInt();
                if (cislo == 0) {
                    break;
                }
                spojovySeznam = new Prvek(cislo, spojovySeznam);
            }



        }

    }
}
