import java.util.*;

class SubstitutionCipher {
    static String key = "QWERTYUIOPASDFGHJKLZXCVBNM";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Text: ");
        String t = s.nextLine().toUpperCase();

        String enc = "", dec = "";
        for(char c: t.toCharArray())
            enc += (c>='A'&&c<='Z') ? key.charAt(c-'A') : c;

        for(char c: enc.toCharArray())
            dec += (c>='A'&&c<='Z') ? (char)('A'+key.indexOf(c)) : c;

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}
