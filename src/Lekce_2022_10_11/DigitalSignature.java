package Lekce_2022_10_11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class DigitalSignature {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        String message = "this is my doc";

        Signature signGen = Signature.getInstance("SHA1withRSA");
        byte[] input = Files.readAllBytes(Paths.get("mujSoukromy.key"));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(input));
        signGen.initSign(privateKey);

        signGen.update(message.getBytes());
        byte[] sign = signGen.sign();

        System.out.println(Base64.getEncoder().encodeToString(sign));
    }
}
