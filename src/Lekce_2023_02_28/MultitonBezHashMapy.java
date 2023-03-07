package Lekce_2023_02_28;

import sun.security.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.HashMap;

public class MultitonBezHashMapy {
    private static Object[][] multitonArrays = new Object[][]{};
    String status;

    private MultitonBezHashMapy() {
        status = "init";
    }

    public static MultitonBezHashMapy getInstance(int key) {
        int idx = -1;
        for (int i = 0; i < multitonArrays.length; i++) {
            Integer kkey = (Integer) multitonArrays[i][0];
            if (kkey == key) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            multitonArrays = concatenate(multitonArrays, new Object[][]{new Object[]{key, new MultitonBezHashMapy()}});
            return (MultitonBezHashMapy) multitonArrays[multitonArrays.length -1][1];
        }
        return (MultitonBezHashMapy) multitonArrays[idx][1];
    }

    // https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
    private static <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

    @Override
    public String toString() {
        return "MultitonBezHashMapy{" +
                "stav='" + status + '\'' +
                '}';
    }
}
