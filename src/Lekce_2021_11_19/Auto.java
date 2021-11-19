package Lekce_2021_11_19;

import java.io.Serializable;

public class Auto implements Serializable {
    String RZ;
    float pohonneHmoty; // v litrech

    public Auto() {
        this.RZ = "";
        this.pohonneHmoty = 0F;
    }

    public Auto(String rz) {
        this.RZ = rz;
        this.pohonneHmoty = 0F;
    }

    public float getPohonneHmoty() {
        return pohonneHmoty;
    }

    public void setPohonneHmoty(float pohonneHmoty) {
        if (pohonneHmoty < 0)
            throw new NumberFormatException("number is negative");

        this.pohonneHmoty = pohonneHmoty;
    }

    public String getRZ() {
        return RZ;
    }

    public void setRZ(String RZ) {
        this.RZ = RZ;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "RZ='" + RZ + '\'' +
                ", pohonneHmoty=" + pohonneHmoty +
                '}';
    }
}
