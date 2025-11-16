import java.util.*;

class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Text: ");
        String text = sc.nextLine();

        System.out.print("Key: ");
        int key = sc.nextInt();

        // Encrypt
        String enc = "";
        for (char c : text.toCharArray())
            enc += (char)(c + key);

        // Decrypt
        String dec = "";
        for (char c : enc.toCharArray())
            dec += (char)(c - key);

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}
