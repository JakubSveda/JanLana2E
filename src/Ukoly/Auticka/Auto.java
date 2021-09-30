package Ukoly.Auticka;

public abstract class Auto {
    /*
     Lepší by bylo vytvořit getter proměnné maxRychlost a vynechat abstraktní metodu mojeMaxRychlost(),
     když ji potom deklarujeme u každého modelu auta.
     Chápu však, že úkol měl být na trénink abstraktních metod...
     */
    protected int maxRychlost;
    private int aktualniRychlost = 0;
    
    public Auto(int maxRychlost) { this.maxRychlost = maxRychlost; }

    public void pridejRychlost() {
        if (aktualniRychlost + 5 > maxRychlost) aktualniRychlost = maxRychlost;
        else aktualniRychlost += 5;
    }

    public void uberRychlost() {
        if (aktualniRychlost - 7 < 0) aktualniRychlost = 0;
        else aktualniRychlost -= 7;
    }

    public void vypisAktualniRychlost() { System.out.println(aktualniRychlost); }
    public abstract int mojeMaxRychlost();
}
