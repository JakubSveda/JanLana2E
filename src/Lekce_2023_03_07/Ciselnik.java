package Lekce_2023_03_07;

public class Ciselnik {
    public static void main(String[] args) {
        KomplexniCislo first = new KomplexniCislo(1, 2);
        KomplexniCislo second = new KomplexniCislo(3, 4);
        KomplexniCislo third = first.add(second);
    }
}
