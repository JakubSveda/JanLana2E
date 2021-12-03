package Ukoly.JSONFormat;

import com.google.gson.Gson;

import java.io.*;

public class Ctenar {
    public static NahodneCislo readNahodneCislo() throws FileNotFoundException {
        Gson gson = new Gson();
        String json = "";


        try {
            InputStream fileInputStream = new FileInputStream("cisla.json");
            StringBuilder stringBuilder = new StringBuilder();

            if (fileInputStream != null) {
                String s = "";

                while ((s = new BufferedReader(new InputStreamReader(fileInputStream)).readLine()) != null){
                    stringBuilder.append(s);
                }

                fileInputStream.close();
                json = stringBuilder.toString();
            }
        } catch (Exception e) {
            return null;
        }

        return gson.fromJson(json, NahodneCislo.class);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(readNahodneCislo().getHodnota());
    }
}
