import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Encryption {
    public static BigInteger encrypt(char c, BigInteger e, BigInteger n) {
        int ascii = (int) c;
        BigInteger m = BigInteger.valueOf(ascii);
        return m.modPow(e, n);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vnesi poraka za sifriranje: ");
        String msg = sc.nextLine();
        System.out.println("Vnesi javen kluc: ");
        int publicKey = sc.nextInt();
        System.out.println("Vnesi go proizvodot od prostite broevi");
        int n = sc.nextInt();

        String encryptedText = IntStream.range(0, msg.length())
                .mapToObj(msg::charAt)
                .map(ch -> encrypt(ch, BigInteger.valueOf(publicKey), BigInteger.valueOf(n)).toString(10))
                .collect(Collectors.joining(","));


        System.out.println("Enkriptiranata poraka e" + encryptedText);
    }
}
