package Lekce_2022_10_18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DecodingWithCertificate {
    public static void main(String[] args) {
        byte[] signedMess = Base64.getDecoder().decode("eXPkrE1ar1M8oxnRkMRbH7+e5D56p8FINrq7E1qqCQvRC94fNzrfB7heiW5tc1IM1XzAmjBX83kepg6zzYH4rg==");
        String message = "Majitel teto zpravy, pokud je mnou podepsana, ma narok dostat z hodiny 1 do bakalaru.";

        try {
            Signature signGen = Signature.getInstance("SHA1withRSA");
            byte[] input = Files.readAllBytes(Paths.get("mujVerejny.key"));
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PublicKey pubKey = kf.generatePublic(new X509EncodedKeySpec(input));
            signGen.initVerify(pubKey);
            System.out.println(String.valueOf(signGen.verify(signedMess)));
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | SignatureException |
                 InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
