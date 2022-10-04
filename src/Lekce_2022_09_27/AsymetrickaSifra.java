package Lekce_2022_09_27;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Arrays;

public class AsymetrickaSifra {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // System.out.println(publicKey);
        // System.out.println(privateKey);

        String str = "babicka";

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.PUBLIC_KEY, publicKey);

        byte[] encryptedBytes = cipher.doFinal(str.getBytes());

        // System.out.println(Arrays.toString(encryptedBytes));

        cipher.init(Cipher.PRIVATE_KEY, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        System.out.println("decrypted: " + new String(decryptedBytes));
    }
}
