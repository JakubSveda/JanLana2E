package Lekce_2023_03_28;

import java.util.Iterator;

public class IteratorRetezce implements Iterator<Character> {

    char[] charArr;
    int count = 0;

    public IteratorRetezce(String s) {
        this.charArr = s.toCharArray();
    }

    @Override
    public boolean hasNext() {
        return charArr.length != count;
    }

    @Override
    public Character next() {
        if (hasNext()) {
            count++;
            return charArr[count-1];
        }

        return null;
    }
}
