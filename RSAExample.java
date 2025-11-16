import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAExample {
    public static void main(String[] args) throws Exception {
        String text = "HelloWorld";

        // Generate RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        // Encrypt
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        String encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes()));
        System.out.println("Encrypted: " + encrypted);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
        String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
        System.out.println("Decrypted: " + decrypted);
    }
}
