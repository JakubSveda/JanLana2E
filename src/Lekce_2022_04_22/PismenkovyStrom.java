package Lekce_2022_04_22;

import java.util.ArrayList;

public class PismenkovyStrom {

    public static void main(String[] args) {
        Potomek p = new Potomek();
        System.out.println(p.addWord("xdd") ? "word added" : "add failed");
        p.toStringAllPotomci();
    }

    public static class Potomek {
        char character;
        int pocetPismen = 0;
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

                    potomci.set(index, p);
                } else {
                    Potomek p = new Potomek(ch, 1);
                    if (!word.isEmpty())
                        p.addWord(word);

                    potomci.add(p);
                }
                return true;
            } else {
                return false;
            }
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
                    "character=" + character +
                    ", pocetSlov=" + pocetPismen +
                    '}';
        }

        public void toStringAllPotomci() {
            if (!potomci.isEmpty()) {
                for (Potomek p : potomci) {
                    System.out.println(p);
                }
            }
        }
    }
}
