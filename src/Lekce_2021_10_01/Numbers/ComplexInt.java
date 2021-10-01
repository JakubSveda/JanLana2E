package Lekce_2021_10_01.Numbers;

public class ComplexInt extends RealInt {
    Integer intValueComplex;

    public ComplexInt(Integer intValue1, Integer intValue2) {
        super(intValue1);
        this.intValueComplex = intValue2;
    }

    public ComplexInt add(ComplexInt y) {
        return new ComplexInt((intValueReal + y.intValueReal), (intValueComplex + y.intValueComplex));
    }

    public ComplexInt mult(ComplexInt y) {
        return new ComplexInt((intValueReal * y.intValueReal - intValueComplex * y.intValueComplex), (intValueReal * y.intValueComplex + intValueComplex * y.intValueReal));
    }

    @Override
    public String toString() {
        return "ComplexInt{" +
                "intValueComplex=" + intValueComplex +
                ", intValueReal=" + intValueReal +
                '}';
    }
}
