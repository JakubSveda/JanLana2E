package Lekce_2023_03_21;

import java.util.Iterator;

public class IteratorJednice<T> implements Iterator<T> {

    Jednice<T> jednice;

    public IteratorJednice(Jednice<T> jednice) {
        this.jednice = jednice;
    }

    @Override
    public boolean hasNext() {
        return jednice != null;
    }

    @Override
    public T next() {
        Jednice<T> jednice2 = jednice;
        jednice = null;
        return jednice2.value;
    }
}
