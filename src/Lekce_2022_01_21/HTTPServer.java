package Lekce_2022_01_21;

import Utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HTTPServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(10000);
            Socket s = ss.accept();
            System.out.println("client connected");

            System.out.println(Utils.readRequest(s));

            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            String htmlMessage = "<html><body><h1>Hello user!</h1><h2>" + date + "</h2></body></html>";
            PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
            pr.println("HTTP/1.1 200 OK");
            pr.println("Content-Type: text/html; charset=UTF-8");
            pr.println();
            pr.println(htmlMessage);

            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
