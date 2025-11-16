import java.util.*;

class SubstitutionCipher {
    static String key = "QWERTYUIOPASDFGHJKLZXCVBNM";

    static String encrypt(String text) {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                result.append(key.charAt(c - 'A'));
            else
                result.append(c);
        }
        return result.toString();
    }

    static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = key.indexOf(c);
            if (index != -1)
                result.append((char) ('A' + index));
            else
                result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String enc = encrypt(text);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + decrypt(enc));
    }
}
