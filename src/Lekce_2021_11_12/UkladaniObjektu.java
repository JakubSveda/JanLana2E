package Lekce_2021_11_12;

import Lekce_2021_10_22.Clovek;

import java.io.*;
import java.util.Scanner;

public class UkladaniObjektu implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String j = sc.next();
            String p = sc.next();
            Clovek cOut = new Clovek(j, p, 10);
            writeInFile("soubor.dat", cOut);
        }

    }

    private static void writeInFile(String fileName, Object o) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        System.out.println(o.toString());
    }
}
