package Lekce_2022_02_25.SpojoveSeznamy;

public class Prvek {
    int hodnota;
    Prvek dalsiPrvek;

    public Prvek(int hodnota, Prvek dalsiPrvek) {
        this.hodnota = hodnota;
        this.dalsiPrvek = dalsiPrvek;
    }

    public Prvek(int hodnota) {
        this.hodnota = hodnota;
    }

    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    public Prvek getDalsiPrvek() {
        return dalsiPrvek;
    }

    public void setDalsiPrvek(Prvek dalsiPrvek) {
        this.dalsiPrvek = dalsiPrvek;
    }
}
