package Ukoly.JSONFormat;

public class NahodneCislo {
    int rozsah;
    double hodnota;

    public NahodneCislo(int rozsah) {
        if (rozsah < 0) throw new NumberFormatException("number is negative or zero");
        this.rozsah = rozsah;
        this.hodnota = Math.random() * rozsah;
    }
}
