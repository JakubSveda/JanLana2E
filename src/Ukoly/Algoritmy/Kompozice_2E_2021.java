package Ukoly.Algoritmy;

import java.util.Arrays;

/**
 * The type Kompozice 2 e 2021.
 */
public class Kompozice_2E_2021 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //System.out.println(isDelitelny(20, 3));
        //printDelitelnaCislaZIntervalu(20, 100);
        //printDvojiceScitancu(6);
        //System.out.println(isInArray(new int[] {1, 2, 3, 4, 5, 6}, 3));
        //System.out.println(calculatePolynom(1, new int[] {0, -2, 6, -8, 0, 0, 5}));
        //System.out.println(maxHodnota(0, 0, 0, -1));
        //System.out.println(cifernySoucet(2092));
        //System.out.println(hasCifra(0, 0));
        //System.out.println(pocetCifer(-27));
        //System.out.println(pocetRuznychCifer(202201));
        //System.out.println(covertTimeFromHours(3));
        //System.out.println(covertTimeFromMinutes(75));
        //System.out.println(covertTimeFromSec(3668));
        System.out.println(nejvetsiSpolecnyDelitelEukliduvAlgoritmus(1, 2));
    }

    /**
     * Is delitelny boolean.
     *
     * @param delenec the delenec
     * @param delitel the delitel
     * @return the boolean
     */
    public static boolean isDelitelny(int delenec, int delitel) {
        return delenec % delitel == 0;
    }

    /**
     * Print delitelna cisla z intervalu.
     *
     * @param delitel        the delitel
     * @param konecIntervalu the konec intervalu
     */
    public static void printDelitelnaCislaZIntervalu(int delitel, int konecIntervalu) {
        int pocitadlo = delitel;
        while (pocitadlo <= konecIntervalu) {
            System.out.println(pocitadlo);
            pocitadlo += delitel;
        }
    }

    /**
     * Print dvojice scitancu.
     *
     * @param x the x
     */
    public static void printDvojiceScitancu(int x) {
        for (int i = 0; i <= x; i++) {
            System.out.println(i + " " + (x - i));
        }
    }

    /**
     * Is in array boolean.
     *
     * @param arr          the arr
     * @param hledaneCislo the hledane cislo
     * @return the boolean
     */
    public static boolean isInArray(int[] arr, int hledaneCislo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == hledaneCislo)
                return true;
        }

        return false;
    }

    /**
     * Calculate polynom int.
     *
     * @param x   the x
     * @param arr the arr
     * @return the int
     */
    public static int calculatePolynom(int x, int[] arr) {
        int vysledek = 0;
        int prubezneX = 1;
        for (int i = 0; i < arr.length; i++) {
            vysledek += prubezneX * arr[i];
            prubezneX *= x;
        }

        return vysledek;
    }

    /**
     * Max hodnota int.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     * @param d the d
     * @return the int
     */
    public static int maxHodnota(int a, int b, int c, int d) {
        if (a >= b && a >= c && a >= d)
            return a;
        if (b >= c && b >= d)
            return b;
        if (c >= d)
            return c;

        return d;
    }

    /**
     * Ciferny soucet int.
     *
     * @param x the x
     * @return the int
     */
    public static int cifernySoucet(int x) {
        int cifernySoucet = 0;
        while (x != 0) {
            cifernySoucet += x % 10;
            x /= 10;
        }

        return cifernySoucet;
    }

    /**
     * Has cifra boolean.
     *
     * @param x     the x
     * @param cifra the cifra
     * @return the boolean
     */
    public static boolean hasCifra(int x, int cifra) {
        if (x == 0) return cifra == 0;
        while (x != 0) {
            if (x % 10 == cifra)
                return true;
            x /= 10;
        }

        return false;
    }

    /**
     * Pocet cifer int.
     *
     * @param x the x
     * @return the int
     */
    public static int pocetCifer(int x) {
        if (x == 0) return 1;
        int pocetCifer = 0;
        while(x != 0) {
            x /= 10;
            pocetCifer++;
        }

        return pocetCifer;
    }

    /**
     * Pocet ruznych cifer int.
     *
     * @param x the x
     * @return the int
     */
    public static int pocetRuznychCifer(int x) {
        if (x == 0) return 1;
        int ruzneCifry = 0;
        int[] cifry = new int[9];
        Arrays.fill(cifry, 0);
        while (x != 0) {
            cifry[x % 10]++;
            x /= 10;
        }

        for (int i = 0; i < cifry.length; i++) {
            if (cifry[i] != 0)
                ruzneCifry++;
        }

        return ruzneCifry;
    }

    /**
     * Covert time from sec string.
     *
     * @param sec the sec
     * @return the string
     */
    public static String covertTimeFromSec(int sec) {
        int h = sec/3600;
        sec %= 3600;
        int min = sec/60;
        sec %= 60;
        return ("h: " + h + " -- min: " + min + " -- sec: " + sec);
    }

    /**
     * Covert time from minutes string.
     *
     * @param min the min
     * @return the string
     */
    public static String covertTimeFromMinutes(int min) {
        int h = min/60;
        min %= 60;
        return ("h: " + h + " -- min: " + min + " -- sec: 0");
    }

    /**
     * Covert time from hours string.
     *
     * @param h the h
     * @return the string
     */
    public static String covertTimeFromHours(int h) {
        return ("h: " + h + " -- min: 0 -- sec: 0");
    }

    /**
     * Nejvetsi spolecny delitel eukliduv algoritmus int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public static int nejvetsiSpolecnyDelitelEukliduvAlgoritmus(int a, int b) {
        while(a != b) {
            if (a < b)
                b -= a;
            else
                a -= b;
        }

        return a;
    }

    /**
     * Nejvetsi spolecny delitel efektivneji int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public static int nejvetsiSpolecnyDelitelEfektivneji(int a, int b) {
        int c;
        while (b != 0) {
            c = b;
            b = a % b;
            a = c;
        }

        return a;
    }

    /**
     * Nejvetsi spolecny delitel rekurzivne int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public static int nejvetsiSpolecnyDelitelRekurzivne(int a, int b) {
        if (b == 0) return a;
        return nejvetsiSpolecnyDelitelRekurzivne(b, a % b);
    }

    /**
     * Nejmensi spolecny nasobek int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public static int nejmensiSpolecnyNasobek(int a, int b) {
        return ((a * b) / nejvetsiSpolecnyDelitelRekurzivne(a, b));
    }

    /**
     * Is prvocislo boolean.
     *
     * @param x the x
     * @return the boolean
     */
    public static boolean isPrvocislo(int x) {
        if (x % 2 == 0) return x == 2;
        int pocitadlo = 3;
        while (pocitadlo * pocitadlo <= x) {
            if (x % pocitadlo == 0)
                return false;
            pocitadlo += 2;
        }

        return true;
    }
}
