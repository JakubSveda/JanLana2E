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
import java.security.spec.PKCS8EncodedKeySpec;

public class AsymDesifrovani {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        byte[] input = Files.readAllBytes(Paths.get("mujSoukromy.key"));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(input));

        cipher.init(Cipher.PRIVATE_KEY, privateKey);

        byte[] decryptedBytes = cipher.doFinal(Files.readAllBytes(Paths.get("zprava.dat")));

        System.out.println(new String(decryptedBytes));
    }
}
