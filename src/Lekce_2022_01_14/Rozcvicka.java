package Lekce_2022_01_14;

public class Rozcvicka extends Thread {
    private final boolean isToHundred;

    @Override
    public void run() {
        if (isToHundred) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = 100; i >= 1; i--) {
                System.out.println(i);
            }
        }
    }

    public Rozcvicka(boolean isToHundred) {
        this.isToHundred = isToHundred;
    }

    public static void main(String[] args) {
        Rozcvicka r1 = new Rozcvicka(true);
        Rozcvicka r2 = new Rozcvicka(false);

        r1.start();
        r2.start();
    }
}
