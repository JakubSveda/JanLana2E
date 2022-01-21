package Lekce_2022_01_21;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ZjistiPorty {
    private static ArrayList<Integer> portsToUse = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 65535; i++) {
            try {
                new ServerSocket(i);
                portsToUse.add(i);
            } catch (IOException ignored) {
            }
        }

        for (int port: portsToUse) {
            System.out.println("port: " + port);
        }

        System.out.println("Can use: " + portsToUse.size());
        System.out.println("Can't use: " + (65535 - portsToUse.size()));

    }
}
