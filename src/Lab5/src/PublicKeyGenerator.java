import javax.sound.midi.Soundbank;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PublicKeyGenerator {
    static int p = 83;
    static int q = 89;

    static int gcd(int e, int z)
    {
        if(e==0)
            return z;
        else
            return gcd(z%e,e);
    }
    public static void main(String[] args) {
        int n;
        int phi;
        int d=0;
        int e;
        int i;

        n = p*q;
        System.out.println("Proizvodot od vnesenite broevi e:" +n);
        phi = (p-1) * (q-1);

        for(e=2; e<phi; e++){
            if(gcd(e,phi)==1){
                break;
            }
        }
    System.out.println("Javniot kluc e: "+e);
        for(i=0;i<=9;i++){
            int x = 1 +(i*phi);
            if(x%e == 0){
                d = x/e;
                break;
            }
        }
        System.out.println("Privatniot kluc e: " +d);
    }

}
