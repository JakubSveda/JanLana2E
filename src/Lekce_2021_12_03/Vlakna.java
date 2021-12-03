package Lekce_2021_12_03;

public class Vlakna extends Thread {
    int[] rozsah = new int[2];
    int duration;

    public Vlakna(int zacatekRozsahu, int konecRozsahu, int duration) {
        this.rozsah[0] = zacatekRozsahu;
        this.rozsah[1] = konecRozsahu;
        this.duration = duration;
    }

    @Override
    public void run() {
        super.run();
        for (int i = this.rozsah[0]; i <= this.rozsah[1]; i++) {
            System.out.println(i);
            try {
                Thread.sleep(this.duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Vlakna(1, 10, 1000));
        Thread t2 = new Thread(new Vlakna(11, 30, 500));
        t1.start();
        t2.start();
    }
}
