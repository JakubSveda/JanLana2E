package Lekce_2021_11_19;

import Lekce_2021_11_12.UkladaniObjektu;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLformat {
    public static void main(String[] args) throws IOException {
        Auto a = new Auto("5AL 5055");

        UkladaniObjektu.writeInFile("soubory/autodraha.dat", a);
        FileOutputStream f = new FileOutputStream("soubory/soubor.xml");
        XMLEncoder encoder = new XMLEncoder(f);
        encoder.writeObject(a);
        encoder.close();

        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("soubory/soubor.xml")));
        Object o = decoder.readObject();
        decoder.close();
        System.out.println(o.toString());
    }
}
