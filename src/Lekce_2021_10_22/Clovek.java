package Lekce_2021_10_22;

import java.io.Serializable;
import java.text.Collator;

public class Clovek implements Comparable, Serializable {
    String krestniJmeno;
    String prijmeni;
    int vek;

    public Clovek(String krestniJmeno, String prijmeni, int vek) {
        this.krestniJmeno = krestniJmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
    }

    @Override
    public String toString() {
        return "Clovek{" +
                "krestniJmeno='" + krestniJmeno + '\'' +
                ", prijmeni='" + prijmeni + '\'' +
                ", vek=" + vek +
                '}';
    }

    public static void main(String[] args) {
        Clovek c1 = new Clovek("Jakub", "Švéda", 16);
        Clovek c2 = new Clovek("Jan", "Cihla", 10);
        Clovek c3 = new Clovek("David", "Cihla", 9);
        Clovek c4 = new Clovek("Barbora", "Švédová", 14);
        Clovek c5 = new Clovek("Anna", "Cihlová", 7);

        Clovek[] zaci = {c1, c2, c3, c4, c5};
        printArr(zaci);

        setridPodleKrestnihoJmena(zaci);

        System.out.println();
        printArr(zaci);

        setridPodlePrijmeni(zaci);

        System.out.println();
        printArr(zaci);

        bubbleSortKrestniJmeno(zaci);

        System.out.println();
        printArr(zaci);

    }

    private static Clovek[] setridPodleKrestnihoJmena(Clovek[] poleClovek) {
        Collator col = Collator.getInstance();

        for (int i = 1; i < poleClovek.length; i++) {
            if (poleClovek[i - 1].krestniJmeno.compareTo(poleClovek[i].krestniJmeno) >= 0) {
                Clovek c = poleClovek[i];
                System.arraycopy(poleClovek, 0, poleClovek, 1, i);
                poleClovek[0] = c;
            }
        }

        return poleClovek;
    }

    private static Clovek[] setridPodlePrijmeni(Clovek[] poleClovek) {
        for (int i = 1; i < poleClovek.length; i++) {
            if (poleClovek[i - 1].prijmeni.compareTo(poleClovek[i].prijmeni) > 0) {
                Clovek c = poleClovek[i];
                System.arraycopy(poleClovek, 0, poleClovek, 1, i);
                /*
                for (int j = i - 1; j >= 0 ; j--) {
                    poleClovek[j + 1] = poleClovek[j];
                }
                 */
                poleClovek[0] = c;
            }
        }

        return poleClovek;
    }

    private static Clovek[] bubbleSortKrestniJmeno(Clovek[] arr) {
        boolean znovu = true;
        while (znovu) {
            boolean currentZmena = false;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1].krestniJmeno.compareTo(arr[i].krestniJmeno) > 0) {
                    Clovek c = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = c;
                    currentZmena = true;
                }
            }

            znovu = currentZmena;
        }


        return arr;
    }

    private static void printArr(Clovek[] arr) {
        for (Clovek c: arr) {
            System.out.println(c);
        }
    }

    @Override
    public int compareTo(Object o) {
        Clovek c = (Clovek) o;
        return krestniJmeno.compareTo(c.krestniJmeno);
    }
}
