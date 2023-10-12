package Lekce_2023_06_20;

import java.util.Iterator;

public class IteratorDvojic implements Iterator<String> {

    String[] values = null;
    int counterX = 0;
    int counterY = 0;

    public IteratorDvojic(String[] words) {
        this.values = words;
    }

    @Override
    public boolean hasNext() {
        return values != null;
    }

    @Override
    public String next() {
        String item = values[counterX] + " " + values[counterY];
        if (++counterY == values.length) {
            counterY = 0;
            if (++counterX == values.length)
                values = null;
        }

        return item;
    }
}
