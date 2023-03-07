package Lekce_2023_02_21;

public class PouzitiJedinacka {
    public static void main(String[] args) {
        Jedinacek j = Jedinacek.getInstance();
        j.setStav("Hotovo");
        System.out.println(j);
    }
}
