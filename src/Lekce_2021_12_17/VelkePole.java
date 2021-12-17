package Lekce_2021_12_17;

import java.util.Arrays;

public class VelkePole {
    private int[] pole = new int[1000000];

    public int delkaPole() {
        return pole.length;
    }

    public synchronized void prictiJedna(int idx) {
        pole[idx]++;
    }

    public int secti() {
        return Arrays.stream(pole).sum();
    }
}
