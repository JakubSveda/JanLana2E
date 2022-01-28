package Lekce_2022_01_28;

import java.math.BigInteger;

public class DalsiPrvocislo {
    private final static BigInteger bigInteger = new BigInteger("123456789");
    private final static BigInteger two = new BigInteger("2");

    public static void main(String[] args) {
        System.out.println(getNextPrvocislo(bigInteger.add(BigInteger.ONE)).toString());
    }

    private static BigInteger getNextPrvocislo(BigInteger bigInteger) {
        while (!isPrvocislo(bigInteger)) {
            bigInteger = bigInteger.add(BigInteger.ONE);
        }

        return bigInteger;
    }

    private static boolean isPrvocislo(BigInteger bigInteger) {
        if (bigInteger.mod(two).compareTo(BigInteger.ZERO) == 0)
            return false;

        BigInteger pocitadlo = bigInteger;
        while (pocitadlo.multiply(pocitadlo).compareTo(bigInteger) <= 0) {
            if (bigInteger.mod(pocitadlo).compareTo(BigInteger.ZERO) == 0)
                return false;

            pocitadlo = pocitadlo.add(two);
        }

        return true;
    }
}
