package Lekce_2022_10_04;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;

public class AsymSifrovani {
    public static void main(String[] args) {
        String password = "password";

        try {
            Cipher cipher = Cipher.getInstance("RSA");
            byte[] input = Files.readAllBytes(Paths.get("mujSoukromy.key"));
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(input));

            cipher.init(Cipher.PUBLIC_KEY, publicKey);

            byte[] encryptedBytes = cipher.doFinal(password.getBytes());

            Files.write(Paths.get("zprava.dat"), encryptedBytes);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException |
                 IOException | InvalidKeySpecException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
