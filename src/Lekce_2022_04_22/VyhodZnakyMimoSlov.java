package Lekce_2022_04_22;

import java.io.*;
import java.util.Scanner;

public class VyhodZnakyMimoSlov {
    public static void main(String[] args) {
        File bible = new File("src/Lekce_2022_04_22/bible.txt");
        try {
            Scanner sc = new Scanner(bible);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArr = line.split("[ .,;!-?:„“/–]");
                for (String str : lineArr) {
                    System.out.print(str + " ");
                }
                System.out.println();
            }

            /*
            while (sc.hasNextLine()) {
                String[] strArr = sc.nextLine().split(" ");
                for (String str: strArr) {
                    StringBuilder finalStr = new StringBuilder();
                    for (int i = 0; i < str.length(); i++) {
                        char thisChar = str.charAt(i);
                        if (thisChar == '.' || thisChar == '!' || thisChar == '"' || thisChar == ',' || thisChar == '„' || thisChar == '“' || thisChar == '?' || thisChar == '/' || thisChar == '-' || thisChar == ':' || thisChar == '–') {
                        } else {
                            finalStr.append(thisChar);
                        }
                    }
                    System.out.print(finalStr.toString() + " ");
                }
                System.out.println();
            }
             */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
