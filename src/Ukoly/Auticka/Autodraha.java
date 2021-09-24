package Ukoly.Auticka;

public class Autodraha {
    public static void main(String[] args) {
        Auto auto = new Auto(80);

        FordModelT fordModelT = new FordModelT();
        for (int i = 0; i < 10; i++) {
            fordModelT.uberRychlost();
        }
        fordModelT.toString();
    }
}
