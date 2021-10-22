package Lekce_2021_10_22.Test.Lide;

public class Zena extends Clovek {
    private float vek;

    public Zena(String krestniJmeno, String prijmeni, float vek) {
        super(krestniJmeno, prijmeni);
        this.vek = vek;
    }

    @Override
    public String toString() {
        return (((vek < 20) ? "slečna" : "paní") + " " + krestniJmeno + " " + prijmeni);
    }

    public static void main(String[] args) {
        Zena z1 = new Zena("Hedvika", "Nováková", 16);
        Zena z2 = new Zena("Zdislava", "Cihlová", 20);
        System.out.println(z1.toString());
        System.out.println(z2.toString());
    }
}
