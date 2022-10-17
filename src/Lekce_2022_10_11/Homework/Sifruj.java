package Lekce_2022_10_11.Homework;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Sifruj {
    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.PUBLIC_KEY, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Files.readAllBytes(Paths.get("public.key")))));
            Files.write(Paths.get("message.dat"), cipher.doFinal(Files.readAllBytes(Paths.get("message.txt"))));
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException |
                 IOException | InvalidKeySpecException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
