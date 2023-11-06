package Lekce_2023_10_16;

public class Rozcvicka {
    public static void main(String[] args) {
        System.out.println(isPrvocislo(111));
    }

    public static boolean isPrvocislo(long x) {
        if (x % 2 == 0) return x == 2;
        for (long i = 3; i * i <= x; i += 2) if (x % i == 0) return false;
        return true;
    }
}
