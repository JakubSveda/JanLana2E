package Lekce_2022_01_07.Filozofove;

import Lekce_2022_01_07.Filozofove.Vidlicka;

public class Filozof extends Thread {
    private final Vidlicka left;
    private final Vidlicka right;
    private String filosofName;

    public Filozof(Vidlicka leva, Vidlicka prava, String name) {
        this.left = leva;
        this.right = prava;
        this.filosofName = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (left) {
                System.out.println(getFilosofName() + " - " + left.getName());
                synchronized (right) {
                    System.out.println(getFilosofName() + " - " + right.getName());
                    try {
                        System.out.println(getFilosofName() + " - jdu spát hoši, sorry");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("BRUH JÁ NESPÍM, INFARKT!");
                    }
                }
            }
        }

    }

    public Vidlicka getLeft() {
        return left;
    }

    public Vidlicka getRight() {
        return right;
    }

    public String getFilosofName() {
        return filosofName;
    }
}
