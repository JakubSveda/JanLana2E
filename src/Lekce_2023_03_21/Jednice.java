package Lekce_2023_03_21;

import java.util.Iterator;

public class Jednice<T> implements Iterable<T> {

    T value;

    public Jednice(T value) {
        this.value = value;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorJednice<>(this);
    }

    public static void main(String[] args) {
        Jednice<Integer> jed1 = new Jednice<>(1);
        Jednice<String> jed2 = new Jednice<>("hello world");

        for (Integer i : jed1) {
            System.out.println(i);
        }

        for (String i : jed2) {
            System.out.println(i);
        }
    }
}
