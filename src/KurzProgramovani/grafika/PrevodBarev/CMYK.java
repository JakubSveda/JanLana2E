package KurzProgramovani.grafika.PrevodBarev;

public class CMYK {
    private final byte c, m, y, k;

    public CMYK(byte c, byte m, byte y, byte k) {
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
    }

    public byte getC() {
        return c;
    }

    public byte getM() {
        return m;
    }

    public byte getY() {
        return y;
    }

    public byte getK() {
        return k;
    }

    @Override
    public String toString() {
        return "CMYK{" +
                "c=" + c +
                ", m=" + m +
                ", y=" + y +
                ", k=" + k +
                '}';
    }
}
