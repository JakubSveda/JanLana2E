package Lekce_24_09_2021.Postavy;

public class Postava {
    String jmeno;
    int zivoty = 100, energie = 100, sila, magie;

    public Postava(String jmeno, int sila, int magie) {
        this.jmeno = jmeno;
        this.sila = sila;
        this.magie = magie;
    }

    public String vypisStav() {
        return jmeno + (" -> " + ((zivoty == 1) ? "zivot" : "zivoty") + " = " + zivoty) + (", energie = " + energie) + (", síla = " + sila) + (", magie = " + magie);
    }

    public void souboj(Postava postava) {
        zivoty -= postava.sila;
        energie -= postava.magie;
        postava.zivoty -= sila;
        postava.energie -= magie;
    }

    //public abstract int getTelesnaSila();
    //public abstract int getMagickaSila();

}
