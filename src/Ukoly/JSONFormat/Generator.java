package Ukoly.JSONFormat;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Generator {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        FileOutputStream f = new FileOutputStream("cisla.json");
        byte[] json = gson.toJson(new NahodneCislo(findNewRozsah()), NahodneCislo.class).getBytes(StandardCharsets.UTF_8);
        f.write(json);
        f.close();
    }

    private static int findNewRozsah() throws FileNotFoundException {
        return (Ctenar.readNahodneCislo() == null) ? 10 : Ctenar.readNahodneCislo().getRozsah() + 10;
    }

}
