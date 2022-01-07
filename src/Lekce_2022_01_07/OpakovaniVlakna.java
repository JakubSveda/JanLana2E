package Lekce_2022_01_07;

public class OpakovaniVlakna extends Thread {
    public static volatile int hodnota;  //volatile = necachovat na procesoru

    public void run() {
        hodnotaSetter();
    }

    private synchronized void hodnotaSetter() {
        for (int i = 0; i < 1000000; i++) {
            hodnota++;
        }
    }

    public static void main(String []args) throws InterruptedException {
        Thread t1 = new OpakovaniVlakna();
        Thread t2 = new OpakovaniVlakna();

        t1.start();
        t2.start();

        t1.join();    // pocka az vlakno t1 skonci
        t2.join();    // pocka az vlakno t2 skonci

        System.out.println(hodnota);
    }
}
