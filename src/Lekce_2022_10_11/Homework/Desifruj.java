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
import java.security.spec.PKCS8EncodedKeySpec;

public class Desifruj {
    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.PRIVATE_KEY, KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Files.readAllBytes(Paths.get("private.key")))));
            System.out.println(new String(cipher.doFinal(Files.readAllBytes(Paths.get("message.dat")))));
        } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | IOException |
                 InvalidKeySpecException | BadPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
