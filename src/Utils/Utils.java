package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.Base64;

public class Utils {
    /*
    public static <T> void forEach(<T>[] arr) {
        for (int i : arr) {

        }
    }
     */
    private static String generateString() {
        StringBuilder str = new StringBuilder();

        for (long i = 0; i < 1000000; i++) {
            str.append("7");
        }

        return str.toString();
    }

    private static void requstURL(URL url) {
        Runnable myThread = () ->
        {
            try {
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        while (true) {
            new Thread(myThread).start();
        }
    }

    public static void main(String[] args) {
        System.out.print(countCharacters("[1,1,1,1,1,1,1,1,{\"id\":\"8.1\",\"description\":\"ano\",\"price\":\"250\"},1,1,1,0,1,1,1,[1,1],[1,1],[0,10000000000000],{\"id\":\"19.1\",\"description\":\"při příští plánované návštěvě\",\"price\":\"2000\"}]"));
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

    public static double min(double... min) {
        double minimum = min[0];
        for (double number : min) {
            if (number < minimum)
                minimum = number;
        }

        return minimum;
    }

    public static int min(int... min) {
        int minimum = min[0];
        for (int number : min) {
            if (number < minimum)
                minimum = number;
        }

        return minimum;
    }

    public static byte min(byte... min) {
        byte minimum = min[0];
        for (byte number : min) {
            if (number < minimum)
                minimum = number;
        }

        return minimum;
    }

    private static String encodeBase64(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    private static int countCharacters(String str) {
        return str.length();
    }

    /*
    public static <T extends Number & Comparable<? super Number>> T min(T...min) {
        T minimum = min[0];
        for (T number: min) {
            if (number.compareTo(minimum) >= 0)
                minimum = number;
        }

        return minimum;
    }
     */
}
