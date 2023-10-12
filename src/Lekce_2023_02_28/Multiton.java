package Lekce_2023_02_28;

import java.util.HashMap;

public class Multiton {
    private static HashMap<Integer, Multiton> singletons = new HashMap<>();
    String status;

    private Multiton() {
        status = "init";
    }

    public static Multiton getInstance(int key) {
        if (!singletons.containsKey(key)) {
            singletons.put(key, new Multiton());
        }
        return singletons.get(key);
    }

    @Override
    public String toString() {
        return "Multiton{" +
                "stav='" + status + '\'' +
                '}';
    }
}
