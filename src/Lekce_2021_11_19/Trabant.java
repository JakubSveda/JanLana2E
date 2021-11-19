package Lekce_2021_11_19;

public class Trabant extends Auto {
    int maxPohonneHmoty = 30;

    public void natankuj(float litry) {
        setPohonneHmoty(((pohonneHmoty + litry) <= maxPohonneHmoty) ? (pohonneHmoty + litry) : maxPohonneHmoty);
    }
}
