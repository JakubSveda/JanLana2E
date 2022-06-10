package KurzProgramovani.grafika.PrevodBarev;

import Utils.Utils;

public class RGB {
    private final byte r, g, b;

    public RGB(byte r, byte g, byte b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public byte getR() {
        return r;
    }

    public byte getG() {
        return g;
    }

    public byte getB() {
        return b;
    }

    public CMYK toCMYK() {
        byte c = (byte) (255 - this.getR());
        byte m = (byte) (255 - this.getG());
        byte y = (byte) (255 - this.getB());
        byte k = (byte) Utils.min(c, m, y);
        c -= k;
        m -= k;
        y -= k;

        return new CMYK(c, m, y, k);
    }

    @Override
    public String toString() {
        return "RGB{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                '}';
    }

    public static void main(String[] args) {
        RGB rgb = new RGB((byte) 255, (byte) 255, (byte) 0);
        CMYK cmyk = rgb.toCMYK();
        System.out.println(cmyk);
        // d = 10cm
        //
    }
}
