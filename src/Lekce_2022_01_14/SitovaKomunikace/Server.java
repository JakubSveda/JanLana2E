package Lekce_2022_01_14.SitovaKomunikace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9990);
            Socket socket = serverSocket.accept();

            System.out.println("client connected");

            //BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //String str = bf.readLine();
            //System.out.println("client: " + str);

            System.out.println(readAll(socket));

            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            pr.println("Let's talk brother!");
            pr.flush();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAll(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null)
            sb.append(line).append("\n");
        return sb.toString();
    }
}
