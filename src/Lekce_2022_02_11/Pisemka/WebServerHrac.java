package Lekce_2022_02_11.Pisemka;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerHrac extends Thread {
    private int poradi = 1;
    private static Socket socket;

    public WebServerHrac(Socket socket) {
        WebServerHrac.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println();

            out.print("<html>" +
                    "<head>\n" +
                    "  <meta charset=\"UTF-8\">\n" +
                    "</head>" +
                    "<body style='text-align: center;'>" +
                    "<h1>");
            String output;
            if (getPoradi() == 13) {
                output = "Vyhrál jsi!!!";
                setPoradi(1);
            } else {
                output = "Jsi " + getPoradi() + ". v pořadí.";
            }
            out.println(output);
            out.println("</h1></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(7890)) {
            while (true) {
                new WebServerHrac(server.accept()).start();
            }
        }
    }

    public int getPoradi() {
        return poradi;
    }

    public void setPoradi(int poradi) {
        this.poradi = poradi;
    }
}
