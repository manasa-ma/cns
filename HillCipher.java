import java.util.*;

class HillCipher {
    static int[][] key = { {3, 3}, {2, 5} };  // example key (invertible mod 26)

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Text (2 letters): ");
        String t = s.next().toUpperCase();

        int a = t.charAt(0) - 'A';
        int b = t.charAt(1) - 'A';

        int c1 = (key[0][0]*a + key[0][1]*b) % 26;
        int c2 = (key[1][0]*a + key[1][1]*b) % 26;

        String enc = "" + (char)(c1+'A') + (char)(c2+'A');
        System.out.println("Encrypted: " + enc);

        // Decryption matrix of key = {{3,3},{2,5}}
        int[][] inv = { {15, 17}, {20, 9} };    // precomputed inverse mod 26

        a = enc.charAt(0) - 'A';
        b = enc.charAt(1) - 'A';

        int d1 = (inv[0][0]*a + inv[0][1]*b) % 26;
        int d2 = (inv[1][0]*a + inv[1][1]*b) % 26;

        // Handle negative values after modulo
        d1 = (d1 + 26) % 26;
        d2 = (d2 + 26) % 26;

        String dec = "" + (char)(d1+'A') + (char)(d2+'A');
        System.out.println("Decrypted: " + dec);
    }
}
