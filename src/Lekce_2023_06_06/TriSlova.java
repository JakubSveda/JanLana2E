package Lekce_2023_06_06;

import java.util.Iterator;

public class TriSlova implements Iterable<String> {
    private String slovoA, slovoB, slovoC;

    public TriSlova(String slovoA, String slovoB, String slovoC) {
        this.slovoA = slovoA;
        this.slovoB = slovoB;
        this.slovoC = slovoC;
    }

    @Override
    public Iterator<String> iterator() {
        return new TriSlovaIterator(slovoA, slovoB, slovoC);
    }

    public static void main(String[] args) {
        TriSlova s = new TriSlova("Jan", "Dan", "pan");

        for (String sl : s) {
            System.out.println(sl);
        }
    }
}
