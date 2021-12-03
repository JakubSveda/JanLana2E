package Lekce_2021_12_03;

import java.util.Scanner;

public class NetrpelivyCtenar {
    public static void main(String[] args) throws InterruptedException {
        Teckovac t = new Teckovac();
        Vstupovac v = new Vstupovac();
        v.start();
        t.start();
        while(v.isAlive()) {
            Thread.sleep(10);
        }
        t.interrupt();

    }

    static class Teckovac extends Thread {
        @Override
        public void run() {
            super.run();

            while(true) {
                System.out.println(".");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    static class Vstupovac extends Thread {
        @Override
        public void run() {
            super.run();

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(input);
        }
    }
}
