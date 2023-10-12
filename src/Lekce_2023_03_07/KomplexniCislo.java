package Lekce_2023_03_07;

public class KomplexniCislo {
    private final double real;
    private final double imaginary;

    public KomplexniCislo(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return real + " + i * " + imaginary;
    }

    public KomplexniCislo add(KomplexniCislo k) {
        return new KomplexniCislo((k.real + real), (k.imaginary + imaginary));
    }
}
