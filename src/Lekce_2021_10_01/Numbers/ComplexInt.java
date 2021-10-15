package Lekce_2021_10_01.Numbers;

public class ComplexInt extends RealInt {
    Integer intValueComplex;

    public ComplexInt(Integer intValueReal) {
        super(intValueReal);
        this.intValueComplex = 0;
    }

    public ComplexInt(Integer intValueReal, Integer intValueComplex) {
        super(intValueReal);
        this.intValueComplex = intValueComplex;
    }

    public ComplexInt add(ComplexInt secondComplex) {
        return new ComplexInt((intValueReal + secondComplex.intValueReal), (intValueComplex + secondComplex.intValueComplex));
    }

    public ComplexInt mult(ComplexInt secondComplex) {
        return new ComplexInt((intValueReal * secondComplex.intValueReal - intValueComplex * secondComplex.intValueComplex), (intValueReal * secondComplex.intValueComplex + intValueComplex * secondComplex.intValueReal));
    }

    @Override
    public String toString() {
        return "ComplexInt{" +
                "intValueReal=" + intValueReal +
                ", intValueComplex=" + intValueComplex +
                '}';
    }
}
