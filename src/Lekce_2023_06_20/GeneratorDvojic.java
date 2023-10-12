package Lekce_2023_06_20;

import java.util.Iterator;
import java.util.Scanner;

public class GeneratorDvojic implements Iterable<String> {
    private String[] words = new String[4];

    public GeneratorDvojic(String[] words) {
        this.words = words;
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorDvojic(words);
    }

    public static void main(String[] args) {
        String[] words = new String[4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            words[i] = scanner.nextLine();
        }

        GeneratorDvojic g = new GeneratorDvojic(words);
        for (String wordDouble : g) {
            System.out.println(wordDouble);
        }
    }
}
