package Lekce_2022_01_07.StopovaciHra;

import static java.lang.System.currentTimeMillis;

public class Odpocet extends Thread {
    @Override
    public void run() {
        long start = currentTimeMillis();
        long now;

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }

            now = currentTimeMillis();
            System.out.println("Timer: " + (now - start) + "ms");
        }
    }
}
