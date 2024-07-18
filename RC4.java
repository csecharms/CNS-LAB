import java.util.Scanner;
public class RC4 {
    private byte[] S = new byte[256];
    private int x = 0;
    private int y = 0;

    public RC4(byte[] key) {
        int keyLength = key.length;
        for (int i = 0; i < 256; i++) {
            S[i] = (byte) i;
        }

        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + key[i % keyLength]) & 0xFF;
            byte temp = S[i];
            S[i] = S[j];
            S[j] = temp;
        }
    }

    public byte[] encryptDecrypt(byte[] data) {
        byte[] result = new byte[data.length];
        for (int k = 0; k < data.length; k++) {
            x = (x + 1) & 0xFF;
            y = (y + S[x]) & 0xFF;

            byte temp = S[x];
            S[x] = S[y];
            S[y] = temp;

            result[k] = (byte) (data[k] ^ S[(S[x] + S[y]) & 0xFF]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter key:");
        String key =sc.nextLine();
        System.out.print("Enter Message:");
        String plaintext = sc.nextLine();
        RC4 rc4 = new RC4(key.getBytes());
        byte[] ciphertext = rc4.encryptDecrypt(plaintext.getBytes());
        System.out.print("Encrypted text: ");
        for (byte b : ciphertext) {
            System.out.printf("%02X ", b);
        }
        System.out.println();
        RC4 rc4Decrypt = new RC4(key.getBytes());
        byte[] decrypted = rc4Decrypt.encryptDecrypt(ciphertext);
        System.out.println("Decrypted text: " + new String(decrypted));
    }
}