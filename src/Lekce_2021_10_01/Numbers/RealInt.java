package Lekce_2021_10_01.Numbers;

public class RealInt {
    Integer intValueReal;

    public RealInt(Integer intValue) {
        this.intValueReal = intValue;
    }

    public RealInt add(RealInt y) {
        return new RealInt(intValueReal + y.intValueReal);
    }

    public RealInt mult(RealInt y) {
        return new RealInt(intValueReal * y.intValueReal);
    }

    @Override
    public String toString() {
        return "RealInt{" +
                "intValueReal=" + intValueReal +
                '}';
    }
}
