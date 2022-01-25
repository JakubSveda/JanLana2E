package Ukoly.HTTPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9999); Socket socket = serverSocket.accept()) {
            String htmlMessage = ("<html><body><pre>" + readRequest(socket) + "</pre></body></html>");
            PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
            pr.println("HTTP/1.1 200 OK");
            pr.println("Content-Type: text/html; charset=UTF-8");
            pr.println();
            pr.println(htmlMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readRequest(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while (true) {
            line = reader.readLine();
            if (line.isEmpty())
                break;
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
