package Lekce_2022_04_22;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class PismenkovyStrom {

    public static void main(String[] args) {
        Potomek p = new Potomek();
        File bible = new File("src/Lekce_2022_04_22/bible.txt");
        try {
            Scanner sc = new Scanner(bible);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArr = line.split("[ .\\[\\],‚ ;!-?:„» “/–‘]");
                for (String str : lineArr) {
                    p.addWord(str.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        p.toStringAllPotomci("");
        System.out.println(p.toStringCurrentSurfaceCounter());
        System.out.println(p.toStringSurface());
    }

    public static class Potomek {
        char character;
        int pocetPismen = 0;
        int pocetSlov = 0;
        ArrayList<Potomek> potomci = new ArrayList<>();
        private int index;

        public Potomek() {
        }

        public Potomek(char ch, int pocetSlov) {
            this.character = ch;
            this.pocetPismen = pocetSlov;
            this.potomci = new ArrayList<Potomek>();
        }

        public boolean addWord(String word) {
            if (!word.isEmpty()) {
                char ch = word.charAt(0);
                word = word.substring(1);

                if (containsPotomek(ch)) {
                    Potomek p = potomci.get(index);
                    p.pocetPismen++;
                    if (!word.isEmpty())
                        p.addWord(word);
                    else
                        p.pocetSlov++;

                    potomci.set(index, p);
                } else {
                    Potomek p = new Potomek(ch, 1);
                    if (!word.isEmpty())
                        p.addWord(word);
                    else
                        p.pocetSlov++;

                    potomci.add(p);
                }
                return true;
            } else
                return false;
        }

        private boolean containsPotomek(char ch) {
            index = 0;
            for (Potomek p : potomci) {
                if (p.character == ch) {
                    return true;
                }
                index++;
            }

            return false;
        }

        @Override
        public String toString() {
            return "Potomek{" +
                    "char=" + character +
                    ", charNumber=" + pocetPismen +
                    '}';
        }

        public void toStringAllPotomci(String before) {
            String newBefore = before + "\t";
            for (Potomek p : potomci) {
                System.out.println(before + p);
                p.toStringAllPotomci(newBefore);
            }
        }

        public int toStringCurrentSurfaceCounter() {
            return potomci.size();
        }

        public String toStringSurface() {
            StringBuilder str = new StringBuilder();
            for (Potomek p: potomci) {
                str.append(p.character);
            }
            return str.toString();
        }

        public int getWordCounter() {

            return -1;
        }
    }
}
