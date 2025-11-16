import java.util.*;

class HillCipher {
    static int[][] keyMatrix = {{3, 3}, {2, 5}}; // 2x2 key

    static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        if (text.length() % 2 != 0) text += "X"; // pad if odd
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            int x = text.charAt(i) - 'A';
            int y = text.charAt(i + 1) - 'A';
            int a = (keyMatrix[0][0]*x + keyMatrix[0][1]*y) % 26;
            int b = (keyMatrix[1][0]*x + keyMatrix[1][1]*y) % 26;
            result.append((char)(a + 'A'));
            result.append((char)(b + 'A'));
        }
        return result.toString();
    }

    static String decrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder result = new StringBuilder();

        int det = keyMatrix[0][0]*keyMatrix[1][1] - keyMatrix[0][1]*keyMatrix[1][0];
        det = (det % 26 + 26) % 26;
        int detInv = 0;
        for (int i = 0; i < 26; i++)
            if ((det * i) % 26 == 1) detInv = i;

        int[][] invKey = new int[2][2];
        invKey[0][0] = keyMatrix[1][1]*detInv % 26;
        invKey[1][1] = keyMatrix[0][0]*detInv % 26;
        invKey[0][1] = (-keyMatrix[0][1] + 26)*detInv % 26;
        invKey[1][0] = (-keyMatrix[1][0] + 26)*detInv % 26;

        for (int i = 0; i < text.length(); i += 2) {
            int x = text.charAt(i) - 'A';
            int y = text.charAt(i + 1) - 'A';
            int a = (invKey[0][0]*x + invKey[0][1]*y) % 26;
            int b = (invKey[1][0]*x + invKey[1][1]*y) % 26;
            result.append((char)((a + 26)%26 + 'A'));
            result.append((char)((b + 26)%26 + 'A'));
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
