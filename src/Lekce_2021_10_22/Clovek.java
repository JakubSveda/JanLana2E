package Lekce_2021_10_22;

public class Clovek {
    String krestniJmeno;
    String prijmeni;

    public Clovek(String krestniJmeno, String prijmeni) {
        this.krestniJmeno = krestniJmeno;
        this.prijmeni = prijmeni;
    }

    @Override
    public String toString() {
        return "Clovek{" +
                "krestniJmeno='" + krestniJmeno + '\'' +
                ", prijmeni='" + prijmeni + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Clovek c1 = new Clovek("Jakub", "Švéda");
        Clovek c2 = new Clovek("Jan", "Cihla");
        Clovek c3 = new Clovek("David", "Cihla");
        Clovek c4 = new Clovek("Barbora", "Švédová");
        Clovek c5 = new Clovek("Anna", "Cihlová");

        Clovek[] zaci = {c1, c2, c3, c4, c5};

        for (Clovek c: zaci) {
            System.out.println(c);
        }

        setridPodleKrestnihoJmena(zaci);

        System.out.println();
        for (Clovek c: zaci) {
            System.out.println(c);
        }
    }

    private static Clovek[] setridPodleKrestnihoJmena(Clovek[] poleClovek) {
        for (int i = 1; i < poleClovek.length; i++) {
            if (poleClovek[i - 1].krestniJmeno.compareTo(poleClovek[i].krestniJmeno) > 0) {
                Clovek c = poleClovek[i];

                for (int j = i - 1; j >= 0 ; j--) {
                    poleClovek[j + 1] = poleClovek[j];
                }

                poleClovek[0] = c;
            }
        }

        return poleClovek;
    }

    private static Clovek[] setridPodleKrestnihoJmena(Clovek[] poleClovek) {
}
