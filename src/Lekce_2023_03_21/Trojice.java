package Lekce_2023_03_21;

import java.util.Iterator;

public class Trojice<T> implements Iterable<T> {
    T first;
    T second;
    T third;

    public Trojice(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorTrojice<>(this);
    }

    public static void main(String[] args) {
        Trojice<String> tr = new Trojice<>("Hello world!", "Ahoj světe!", "Hallo Welt!");
        Trojice<Integer> troj = new Trojice<>(1, 2, 3);


        for (Iterator<String> itStr = tr.iterator(); itStr.hasNext();) {
            String str = itStr.next();
            System.out.println(str);
        }

        for (String str : tr) {
            System.out.println(str);
        }

        for (Iterator<Integer> itInt = troj.iterator(); itInt.hasNext();) {
            Integer str = itInt.next();
            System.out.println(str);
        }

        for (Integer str : troj) {
            System.out.println(str);
        }
    }
}
