package Lekce_2022_10_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;

public class AsymSGenerator {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            Files.write(Paths.get("public.key"), publicKey.getEncoded());
            Files.write(Paths.get("private.key"), privateKey.getEncoded());
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
