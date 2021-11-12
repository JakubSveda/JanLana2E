package Ukoly.Clovek;

import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Scanner;

public class ClovekSorter {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        Scanner sc = new Scanner(file);
        Collator col = Collator.getInstance();
        ArrayList<Clovek> clovekArrayList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] stringArr = sc.nextLine().split(" ");
            clovekArrayList.add(new Clovek(stringArr[0], stringArr[1], Integer.parseInt(stringArr[2])));
        }

        boolean zmena = true;
        while (zmena) {
            if (clovekArrayList.size() < 2) break;
            boolean localZmena = false;

            for (int i = 1; i < clovekArrayList.size(); i++) {
                int comparePrijmeni = col.compare(clovekArrayList.get(i).prijmeni, clovekArrayList.get(i-1).prijmeni);

                if (comparePrijmeni < 0) {
                    Clovek c = clovekArrayList.get(i);
                    clovekArrayList.set(i, clovekArrayList.get(i-1));
                    clovekArrayList.set(i-1, c);
                    localZmena = true;
                } else if (comparePrijmeni == 0) {
                    int compareKrestniJmeno = col.compare(clovekArrayList.get(i).krestniJmeno, clovekArrayList.get(i-1).krestniJmeno);

                    if (compareKrestniJmeno < 0) {
                        Clovek c = clovekArrayList.get(i);
                        clovekArrayList.set(i, clovekArrayList.get(i-1));
                        clovekArrayList.set(i-1, c);
                        localZmena = true;
                    } else if (compareKrestniJmeno == 0) {
                        if (clovekArrayList.get(i).vek < clovekArrayList.get(i-1).vek) {
                            Clovek c = clovekArrayList.get(i);
                            clovekArrayList.set(i, clovekArrayList.get(i-1));
                            clovekArrayList.set(i-1, c);
                            localZmena = true;
                        }
                    }
                }
            }

            zmena = localZmena;
        }

        for (Clovek c : clovekArrayList) {
            System.out.println(c.toString());
        }
    }
}
