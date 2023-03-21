package Lekce_2023_03_07;

public class Psickova implements Jidlo {
    private boolean detska;
    public Psickova() {
        this.detska = false;
    }
    public Psickova(boolean detska) {
        this.detska = detska;
    }
    public int dejCenu() {
        return detska ? 500 : 1000;
    }

    public String vyrobTo() {
        return detska ? "2 nohy psicka a zbytek" : "1 psíček, dochutit, 5 houskových knedlíků";
    }
}
