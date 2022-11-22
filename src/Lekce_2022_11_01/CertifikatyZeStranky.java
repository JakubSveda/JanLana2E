package Lekce_2022_11_01;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;

public class CertifikatyZeStranky {
    public static void main(String[] args) {
        try {
            URL destinationURL = new URL("https://servis3p.cz");
            HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
            conn.connect();
            Certificate[] certs = conn.getServerCertificates();
            for (Certificate cer: certs) {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println(cer.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
