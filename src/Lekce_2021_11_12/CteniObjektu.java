package Lekce_2021_11_12;

import Lekce_2021_10_22.Clovek;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CteniObjektu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("soubor.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        for (int i = 0; i < 3; i++) {
            try {
                Clovek cIn = (Clovek) objectInputStream.readObject();
                System.out.println(cIn.toString());
            } catch (Exception e) {
                break;
            }
        }
    }
}
