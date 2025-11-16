import java.security.*;
import java.util.Scanner;
import java.util.Formatter;

public class SHA1Demo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(text.getBytes());

        // Convert bytes to hex
        Formatter f = new Formatter();
        for (byte b : digest) f.format("%02x", b);

        System.out.println("SHA-1 Digest: " + f);
        f.close();
    }
}
