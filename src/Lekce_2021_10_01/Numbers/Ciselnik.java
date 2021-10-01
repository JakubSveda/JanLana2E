package Lekce_2021_10_01.Numbers;

public class Ciselnik {
    public static void main(String[] args) {
        RealInt x = new RealInt(100);
        RealInt y = new RealInt(20);

        x.add(y);
        System.out.println(x + "\n");

        ComplexInt a = new ComplexInt(100, 20);
        ComplexInt b = new ComplexInt(10, 2);

        a.add(b);
        System.out.println(a);
    }
}
