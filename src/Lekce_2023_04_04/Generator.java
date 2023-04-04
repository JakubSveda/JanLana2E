package Lekce_2023_04_04;

import java.util.Iterator;

public class Generator implements Iterator<Integer> {
    private final int max;
    private int next = 2;

    public Generator(Integer maxValue) {
        this.max = maxValue;
    }

    private boolean isPrimaryNumber(int a) {
        if (a % 2 == 0)
            return (a == 2);

        return loop(a, 3);
    }

    private boolean loop(int a, int b) {
        if (b * b <= a)
            return !((a % b != 0) || loop(a, ++b));

        return true;
    }

    @Override
    public boolean hasNext() {
        return next <= max;
    }

    @Override
    public Integer next() {
        int current = next;
        for (int i = next + 1; i != next; i++)
            if (isPrimaryNumber(i))
                next = i--;

        return current;
    }
}
