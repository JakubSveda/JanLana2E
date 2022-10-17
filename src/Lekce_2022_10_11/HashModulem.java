package Lekce_2022_10_11;

import java.util.Scanner;

public class HashModulem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int hash = hash(input);
        System.out.println(hash);
    }

    private static int hash(String input) {
        int hash = 0;
        for (int ch: input.toCharArray()) {
            hash += ch;
        }

        return hash % 127;
    }
}
