package KurzProgramovani.Lekce_2022_06_01;

public class RozpoznavaciSchopnostLidskehoOka {
    private static final double INCH = 2.54;
    private static final double ANGLE = 2 * Math.PI/180/60; // 1min

    public static void main(String[] args) {
        System.out.println("Vzdálenost mezi body: " + rozpoznavaciSchopnost(10) + " cm");
        System.out.println("DPI: " + dpiValue(rozpoznavaciSchopnost(10)));
        System.out.println("Vzdálenost od objektů: " + vzdalenostMeziObjekty(0.01) + " cm =>" + vzdalenostMeziObjekty(0.01)/100 + " m ");
    }

    public static double rozpoznavaciSchopnost(double d) {
        return d * Math.tan(ANGLE);
    }

    public static double dpiValue(double d) {
        return INCH / d;
    }

    public static double vzdalenostMeziObjekty(double h) {
        return h / Math.tan(ANGLE);
    }
}
