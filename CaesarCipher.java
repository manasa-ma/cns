import java.util.*;

class CaesarCipher {
    static String encrypt(String text, int key) {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();
        key %= 26;
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                result.append((char) ('A' + (c - 'A' + key) % 26));
            else
                result.append(c);
        }
        return result.toString();
    }

    static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter key: ");
        int key = sc.nextInt();

        String enc = encrypt(text, key);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + decrypt(enc, key));
    }
}

