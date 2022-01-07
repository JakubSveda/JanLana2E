package Lekce_2022_01_07.StopovaciHra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class StopovaciHra {
    public static void main(String[] args) {
        Odpocet o = new Odpocet();

        o.start();

        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        o.interrupt();

    }
}
