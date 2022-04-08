package Lekce_2022_04_08;

public class Strom {
    private static Uzel koren = null;

    public static void main(String[] args) {
        koren = new Uzel(20, new Uzel(5, new Uzel(1), new Uzel(13)), new Uzel(50, new Uzel(27), new Uzel(100)));
        //System.out.println(koren);
        System.out.println(koren.isInTree(100));
    }

    /*
    private static void addToBinaryTree(int value, Uzel levy, Uzel pravy) {
        return new Uzel(value, levy, pravy);
    }
     */

    public static class Uzel {
        int value;
        Uzel pravy = null, levy = null;

        public Uzel(int value, Uzel pravy, Uzel levy) {
            this.value = value;
            this.pravy = pravy;
            this.levy = levy;
        }

        public Uzel(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            Uzel koren = new Uzel(value, levy, pravy);
            System.out.print(value);
            return sout(koren);
        }

        private String sout(Uzel koren) {
            if (levy == null || pravy == null) {
                return "";
            } else {
                return "\n\t" + koren.levy.value + "\n\t" + koren.pravy.value;
            }
        }

        public boolean isInTree(int toFind) {
            if (value == toFind)
                return true;
            if (pravy != null && pravy.isInTree(toFind))
                return true;
            if (levy != null && levy.isInTree(toFind))
                return true;

            return false;
        }
    }
}
