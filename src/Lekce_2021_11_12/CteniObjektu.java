package Lekce_2021_11_12;

import Lekce_2021_10_22.Clovek;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CteniObjektu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("soubor.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Clovek> clovekArrayList = (ArrayList<Clovek>) objectInputStream.readObject();
        System.out.println(clovekArrayList.toString());
    }
}
