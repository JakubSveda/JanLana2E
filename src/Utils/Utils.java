package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Utils {
    /*
    public static <T> void forEach(<T>[] arr) {
        for (int i : arr) {

        }
    }
     */

    public static void main(String[] args) {
        String s = "domény poštovního serveru v cloudu (např. Office365,";
        System.out.println(s.length());
    }

    public static String readRequest(Socket socket) throws IOException {
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
