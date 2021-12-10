package Lekce_2021_12_10;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Knihovna {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String pozadavek = sc.next();
        if (pozadavek == "add") {
            add();
        } else if (pozadavek == "list") {
            readKnihyKnihovny();
        } else if (pozadavek == "list-author") {
            readKnihyPodleAutora();
        } else if (pozadavek == "delete") {
            deleteKnihaPodleNazvu();
        }
    }

    private static void add() {
        String input = "";
        while (sc.hasNext()) {
            input += sc.next() + " ";
        }

        ArrayList<String> knihovna = readObject();
        knihovna.add(input);

        writeObject(knihovna);
    }

    private static void readKnihyKnihovny() {
        ArrayList<String> knihovna = readObject();

        if (knihovna != null) {
            for (String s: knihovna) {
                String[] casti = s.split(" ");
                if (casti.length > 3) {
                    String vypis = casti[casti.length - 3] + " " + casti[casti.length - 2] + " " + casti[casti.length - 1];

                    for (int i = 0; i < casti.length - 3; i++) {
                        vypis += casti[i] + "_";
                    }

                    System.out.println(vypis);
                } else {
                    String vypis = "";
                    for (String str: casti) {
                        vypis += str + " ";
                    }

                    System.out.println(vypis);
                }
            }
        }
    }

    private static void readKnihyPodleAutora() {
        ArrayList<String> knihovna = readObject();

        // pokud by knihy měli autora se stejným příjmením, nemusí určit správně jejich pořadí (nestihl jsem dodělat)
        for (int i = 0; i < knihovna.size(); i++) {
            String[] split = knihovna.get(i).split(" ");
            String min = split[split.length - 2];
            for (int j = i; j < knihovna.size(); j++) {
                String[] split2 = knihovna.get(j).split(" ");
                String thisPrijmeni = split2[split.length - 2];
                if ( thisPrijmeni.compareTo(min) > 0) {
                    String vymena = knihovna.get(i);
                    knihovna.set(i, knihovna.get(j));
                    knihovna.set(j, vymena);
                }
            }
        }

        for (String s: knihovna) {
            System.out.println(s);
        }
    }

    private static void deleteKnihaPodleNazvu() {
        ArrayList<String> knihovna = readObject();
        String nazevKnihy = sc.nextLine();

        if (knihovna != null) {
            for (int i = 0; i < knihovna.size(); i++) {
                String[] casti = knihovna.get(i).split(" ");
                if (casti[casti.length - 1].equals(nazevKnihy)) {
                    knihovna.remove(i);
                }
            }

            writeObject(knihovna);
        }
    }

    private static ArrayList<String> readObject() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("knihovna.dat");
            ois = new ObjectInputStream(fis);
            ArrayList<String> knihovna = (ArrayList<String>) ois.readObject();
            return knihovna;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private static void writeObject(ArrayList<String> knihovna) {
        FileOutputStream fos = null;
        ObjectOutputStream ous = null;
        try {
            fos = new FileOutputStream("knihovna.dat");
            ous = new ObjectOutputStream(fos);
            ous.writeObject(knihovna);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (ous != null) {
                    ous.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
