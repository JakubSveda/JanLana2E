package Lekce_2023_04_04;

import java.util.Iterator;

public class Prvocislo implements Iterable<Integer> {
    private final int max;

    public Prvocislo(int maxValue) {
        if (maxValue < 0)
            throw new IllegalArgumentException("maxValue should not be negative");

        this.max = maxValue;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Generator(max);
    }

    public static void main(String[] args) {
        new Prvocislo(10).forEach(value -> System.out.print(value + " "));
    }
}
