package Lekce_2021_12_03;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Opakovani {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("soubor.dat")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
            for (String s: arrayList) {
                System.out.println(s);
            }

            arrayList.add(sc.nextLine());
            try {
                FileOutputStream fos = new FileOutputStream("soubor.dat");
                ObjectOutputStream ous = new ObjectOutputStream(fos);
                ous.writeObject(arrayList);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            ArrayList<String> arrList = new ArrayList<>();
            arrList.add(sc.nextLine());
            try {
                FileOutputStream fos = new FileOutputStream("soubor.dat");
                ObjectOutputStream ous = new ObjectOutputStream(fos);
                ous.writeObject(arrList);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
