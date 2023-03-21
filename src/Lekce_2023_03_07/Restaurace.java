package Lekce_2023_03_07;

public class Restaurace {
    public static void main(String[] args) {
        Jidlo j = TovarnaNaJidlo.vyrobJidlo("dort");
        Jidlo j2 = TovarnaNaJidlo.vyrobJidlo("psíčková");
        Jidlo j3 = TovarnaNaJidlo.vyrobJidlo("dětská psíčková");

        System.out.println("cena: " + j.dejCenu() + "Kč");
        System.out.println("recept: " + j.vyrobTo());
        System.out.println();
        System.out.println("cena: " + j2.dejCenu() + "Kč");
        System.out.println("recept: " + j2.vyrobTo());
        System.out.println();
        System.out.println("cena: " + j3.dejCenu() + "Kč");
        System.out.println("recept: " + j3.vyrobTo());
    }
}
