package Lekce_2022_01_14.SitovaKomunikace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);

            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            pr.println("I am client!!!");
            pr.flush();

            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = bf.readLine();
            System.out.println("server: " + str);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
