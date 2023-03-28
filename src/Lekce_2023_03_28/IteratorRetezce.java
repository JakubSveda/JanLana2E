package Lekce_2023_03_28;

import java.util.Iterator;

public class IteratorRetezce implements Iterator<Character> {

    int count = 0;
    char[] charArr;

    public IteratorRetezce(String str) {
        charArr = str.toCharArray();
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
