package Lekce_2021_11_26;

import Ukoly.JSONFormat.NahodneCislo;
import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        String[] s = {"abcde", "xyzzzz"};

        Gson g = new Gson();
        System.out.println(g.toJson(s));
    }
}
