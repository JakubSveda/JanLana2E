package Lekce_2021_12_17;

import java.util.Arrays;

public class VetsiODva {
    public static void main(String[] args) throws InterruptedException {
        VelkePole v = new VelkePole();
        Zvetsovac z = new Zvetsovac(v);
        Zvetsovac z2 = new Zvetsovac(v);
        z.start();
        z2.start();
        z.join();
        z2.join();

        System.out.println(v.secti());
    }
}
