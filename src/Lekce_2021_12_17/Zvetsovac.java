package Lekce_2021_12_17;

public class Zvetsovac extends Thread {
    VelkePole v;

    public Zvetsovac(VelkePole v) {
        this.v = v;
    }

    @Override
    public void run() {
        for (int i = 0; i < v.delkaPole(); i++) {
            v.prictiJedna(i);
        }
    }
}
