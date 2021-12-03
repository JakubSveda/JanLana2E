package Ukoly.JSONFormat;

import java.util.concurrent.ThreadLocalRandom;

public class NahodneCislo {
    int rozsah;
    double hodnota;

    public NahodneCislo(int rozsah) {
        if (rozsah < 0) throw new NumberFormatException("number is negative or zero");
        this.rozsah = rozsah;
        this.hodnota = ThreadLocalRandom.current().nextDouble(0, rozsah);
    }

    public int getRozsah() {
        return rozsah;
    }

    public double getHodnota() {
        return hodnota;
    }

}
