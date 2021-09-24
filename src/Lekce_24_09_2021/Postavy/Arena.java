package Lekce_24_09_2021.Postavy;

public class Arena {
    public static void main(String[] args) {
        Postava jakub = new Postava("Jakub", 10, 12);
        System.out.println(jakub.vypisStav());

        Hranicar hranicar = new Hranicar();
        System.out.println(hranicar.vypisStav());

        Kouzelnik kouzelnik = new Kouzelnik();
        System.out.println(kouzelnik.vypisStav());

        System.out.println("\n");

        jakub.souboj(hranicar);
        System.out.println(jakub.vypisStav());
        System.out.println(hranicar.vypisStav());
    }
}
