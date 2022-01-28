package Lekce_2022_01_28;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerVicePozadavku extends Thread {
    private static Socket socket;

    public ServerVicePozadavku(Socket socket) {
        ServerVicePozadavku.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("pozadavek..");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), false);

            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println();

            out.print("<html><body><pre>");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    out.print(i);
                    Thread.sleep(100);
                    out.flush();
                }
                out.println();
            }
            out.print("</pre></body></html>");

            out.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        try (ServerSocket server = new ServerSocket(10000)) {
            while (true) {
                new ServerVicePozadavku(server.accept()).start();
            }
        }
    }
}
