package Lekce_2022_04_08;

import java.util.ArrayList;

public class PismenkovyStrom {

    public static class Potomek {
        char character;
        int pocetSov;
        ArrayList<Potomek> potomci;

        public Potomek(char ch, int pocetSov) {
            this.character = ch;
            this.pocetSov = pocetSov;
            this.potomci = new ArrayList<Potomek>();
        }

        public int addWord(String word) {
            if (!word.isEmpty()) {
                char ch = word.charAt(0);
                if (hasPotomek(ch)) {
                     Potomek p = potomci.get(potomci.indexOf(ch))
                } else {
                    potomci.add(new Potomek(ch, 1));
                }
            } else {
                return -1;
            }
        }

        private char[] hasPotomekAndIndex(char ch) {
            char[] chArr = new char[3];
            for (Potomek p: potomci) {
                if (p.character == ch) {
                    chArr = {}
                }
            }

            return chArr;
        }
    }
}
