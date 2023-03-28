package Lekce_2023_03_28;

import java.util.Iterator;

public class MujRetezec implements Iterable<Character> {
    String str;

    public MujRetezec(String str) {
        this.str = str;
    }

    @Override
    public Iterator<Character> iterator() {
        return new IteratorRetezce(str);
    }

    public static void main(String[] args) {
        MujRetezec mr = new MujRetezec("Ahoj");

        for (char s : mr) {
            System.out.println(s);
        }
    }
}
