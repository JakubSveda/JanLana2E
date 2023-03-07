package Lekce_2023_02_28;

public class PouzitiMultitonu {
    public static void main(String[] args) {
        Multiton m1 = Multiton.getInstance(0);
        Multiton m2 = Multiton.getInstance(100);
        Multiton m3 = Multiton.getInstance(0);

        m1.status = "jedna";
        m2.status = "pet";
        m3.status = "tri";

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        MultitonBezHashMapy mm1 = MultitonBezHashMapy.getInstance(0);
        MultitonBezHashMapy mm2 = MultitonBezHashMapy.getInstance(100);
        MultitonBezHashMapy mm3 = MultitonBezHashMapy.getInstance(0);

        mm1.status = "jedna";
        mm2.status = "pet";
        mm3.status = "tri";

        System.out.println(mm1);
        System.out.println(mm2);
        System.out.println(mm3);
    }
}
