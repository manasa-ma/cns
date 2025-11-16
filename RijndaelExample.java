import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class RijndaelExample {
    public static void main(String[] args) throws Exception {
        String text = "HelloWorld";

        // Generate AES key (Rijndael block size = 128 bits)
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();

        // Encrypt
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes()));
        System.out.println("Encrypted: " + encrypted);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, key);
        String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
        System.out.println("Decrypted: " + decrypted);
    }
}
