package Lekce_2021_10_22.Test.Lide;

public class Muz extends Clovek {
    public Muz(String krestniJmeno, String prijmeni) {
        super(krestniJmeno, prijmeni);
    }

    @Override
    public String toString() {
        return ("pan " + krestniJmeno + " " + prijmeni);
    }

    public static void main(String[] args) {
        Muz m1 = new Muz("Jan", "Lána");
        Muz m2 = new Muz("Jakub", "Švéda");
        System.out.println(m1.toString());
        System.out.println(m2.toString());
    }
}
