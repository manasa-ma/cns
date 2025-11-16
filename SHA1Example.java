import java.security.*;
import java.util.Scanner;
import java.util.Base64;

public class SHA1Example {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Create SHA-1 MessageDigest
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(text.getBytes());

        // Convert to hex string
        StringBuilder hex = new StringBuilder();
        for(byte b : digest) {
            hex.append(String.format("%02x", b));
        }

        System.out.println("SHA-1 Digest (hex): " + hex);
    }
}
