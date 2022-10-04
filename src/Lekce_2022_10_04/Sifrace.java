package Lekce_2022_10_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sifrace {
    public static void main(String[] args) throws IOException {
        String str = "ahoj";
        char[] charArr = str.toCharArray();
        String finalString = "";

        for (char ch: charArr) {
            String characterBinary = "";
            int charValue = ch;
            while (charValue != 0 || charValue != 1) {
                characterBinary = characterBinary + charValue % 2;
                charValue /= 2;
            }
            characterBinary = characterBinary + charValue;
            characterBinary = characterBinary.replaceAll("0", " ").replaceAll("1", "\t") + "\n";
            finalString += characterBinary;
        }

        Files.write(Paths.get("soubor.txt"), finalString.toString().getBytes());
        System.out.println(finalString.toString());
    }
}
