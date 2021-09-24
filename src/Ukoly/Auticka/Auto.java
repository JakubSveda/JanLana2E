package Ukoly.Auticka;

public class Auto {
    private int maxRychlost, aktualniRychlost;

    public Auto(int maxRychlost) {
        this.maxRychlost = maxRychlost;
    }

    public void pridejRychlost() {
        if (aktualniRychlost + 5 > maxRychlost) aktualniRychlost = maxRychlost;
        else aktualniRychlost += 5;
    }

    public void uberRychlost() {
        if (aktualniRychlost - 7 < 0) aktualniRychlost = 0;
        else aktualniRychlost -= 7;
    }

    public String toString() {
        System.out.println(aktualniRychlost);
        return aktualniRychlost + "";
    }
}
