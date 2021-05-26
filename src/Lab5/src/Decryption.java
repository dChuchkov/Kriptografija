import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Decryption {

    public static String decrypt (BigInteger c, BigInteger d, BigInteger n) {
        return String.valueOf((char) c.modPow(d,n).intValue());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vnesi sifrirana poraka: ");
        String encryptedMsg = sc.nextLine();
        System.out.println("Vnesi privaten kluc: ");
        int privateKey = sc.nextInt();
        System.out.println("Vnesi go proizvodot od prostite broevi: ");
        int n = sc.nextInt();

        String decryptedMsg = Arrays.stream(encryptedMsg.split(","))
                .map(BigInteger::new)
                .map(bi -> decrypt(bi, BigInteger.valueOf(privateKey), BigInteger.valueOf(n)))
                .collect(Collectors.joining());

        System.out.println("Decrypted message is: ");
        System.out.println(decryptedMsg);
    }
}
