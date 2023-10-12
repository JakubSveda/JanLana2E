package Lekce_2023_06_06;

import java.util.Iterator;

public class TriSlovaIterator implements Iterator<String> {

    private String[] words = null;
    private int index = 0;

    public TriSlovaIterator(String a, String b, String c) {
        this.words = new String[]{a, b, c};
    }

    @Override
    public boolean hasNext() {
        return words != null;
    }

    @Override
    public String next() {
        String exit = words[index];


        return exit;
    }
}
