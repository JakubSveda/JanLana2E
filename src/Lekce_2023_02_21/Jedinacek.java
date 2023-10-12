package Lekce_2023_02_21;

public class Jedinacek {
    private String stav;
    private static Jedinacek singletonInstance;
    private Jedinacek() {
        stav = "init";
    }

    public static Jedinacek getInstance() {
        if (null == singletonInstance) {
            singletonInstance = new Jedinacek();
        }
        return singletonInstance;
    }

    public void setStav(String s) {
        stav = s;
    }

    @Override
    public String toString() {
        return "Jedinacek{" +
                "stav='" + stav + '\'' +
                '}';
    }
}
