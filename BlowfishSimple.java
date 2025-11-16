import java.util.*;

class BlowfishSimple  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        char[] enc = new char[text.length()];
        char[] dec = new char[text.length()];

        for(int i=0; i<text.length(); i++){
            enc[i] = (char)(((text.charAt(i) ^ key.charAt(i % key.length())) % 94) + 33); // printable ASCII 33-126
            dec[i] = (char)(((enc[i] - 33) ^ key.charAt(i % key.length())));             // reverse
        }

        System.out.println("Plaintext : " + text);
        System.out.println("Encrypted : " + new String(enc));
        System.out.println("Decrypted : " + new String(dec));
    }
}
