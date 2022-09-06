package Lekce_2022_09_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MedianZeSouboru {
    public static void main(String[] args) {
        System.out.println(getMedianFromFile(new File("src/Lekce_2022_09_06/vstup.txt")));
    }

    private static double getMedianFromFile(File file) {
        ArrayList<Integer> cisla = new ArrayList<>();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext())
                cisla.add(scan.nextInt());
            Collections.sort(cisla);
            return (cisla.size() % 2 == 0) ? ((cisla.get(cisla.size()/2) + cisla.get(cisla.size()/2 - 1)) / 2.0) : cisla.get(cisla.size()/2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
