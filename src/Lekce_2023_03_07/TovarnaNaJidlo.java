package Lekce_2023_03_07;

public class TovarnaNaJidlo {
    public static Jidlo vyrobJidlo(String jmenoJidla) {
        if (jmenoJidla == null) {
            return null;
        } else if (jmenoJidla.equals("dort")) {
            return new DortPejskaAKocicky();
        } else if (jmenoJidla.equals("psíčková")) {
            return new Psickova();
        } else if (jmenoJidla.equals("dětská psíčková")) {
            return new Psickova(true);
        } else {
            throw new IllegalArgumentException("Nezname jidlo.");
        }
    }
}
