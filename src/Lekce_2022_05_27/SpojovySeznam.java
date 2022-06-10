package Lekce_2022_05_27;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class SpojovySeznam {
    private static Vrchol list = null;

    public static void main(String[] args) {
        createList("src/Lekce_2022_05_27/bible.txt");
        printList();
        //System.out.println(findShortestLine());
        printAndRemoveList();
    }

    private static void remove(int position) {
        for (int i = 0; i < position-2; i++) {
            list = list.next;
        }

        list.next = list.next.next;
        list = list.next;
    }

    private static void printList() {
        Vrchol x = list.next;
        System.out.print(list.value + " \n");
        while (!Objects.equals(x.value, list.value)) {
            System.out.print(x.value + " \n");
            x = x.next;
        }
    }

    private static void printAndRemoveList() {
        while (list.next != null)
            System.out.println(findShortestLine());
    }

    private static String findShortestLine() {
        Vrchol x = list.next;
        String shortest = list.value;
        int position = 0;
        int finalPosition = 0;
        while (!Objects.equals(x.value, list.value)) {
            if (minMaxString(x.value, shortest)) {
                shortest = x.value;
                finalPosition = position;
            }

            position++;
            x = x.next;
        }

        remove(finalPosition);

        return shortest;
    }

    private static String findLongestLine() {
        Vrchol x = list.next;
        String longest = list.value;
        while (!Objects.equals(x.value, list.value)) {
            if (!minMaxString(x.value, longest))
                longest = x.value;
            x = x.next;
        }

        return longest;
    }

    private static boolean minMaxString(String a, String b) {
        return (a.length() > 0) && (a.length() < b.length());
    }

    private static void createList(String filePath) {
        try (Scanner scan = new Scanner(new File(filePath))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (!line.isEmpty())
                    list = new Vrchol(line, list);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Čtení se pokazilo!");
            e.printStackTrace();
        }

        Vrchol last = list;
        while (last.next != null) {
            last = last.next;
        }

        last.next = list;
    }

    private static class Vrchol {
        String value;
        Vrchol next = null;

        public Vrchol(String value, Vrchol next) {
            this.value = value;
            this.next = next;
        }

        public Vrchol(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
