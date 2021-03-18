package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Decryption {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File out = new File("C:\\Users\\damja\\Desktop\\out.txt");
        PrintWriter pw = new PrintWriter(out,"UTF-8");
        Scanner sc = new Scanner(System.in);
        Character [] alphabet = {'А','Б','В','Г','Д','Ѓ','Е','Ж','З','Ѕ','И','Ј','К','Л','Љ','М','Н','Њ','О','П','Р','С','Т','Ќ','У','Ф','Х','Ц','Ч','Џ','Ш'};
        Character [] permutation_alphabet = {'Н','Б','Г','В','Р','Ѓ','Ј','О','З','Ѕ','П','Е','К','М','С','Л','А','К','Ж','И','Д','С','Т','Ќ','У','Ф','Т','Ш','Ч','Б','Ц'};
        Map<Character,Character> permutation =  IntStream.range(0, alphabet.length).boxed().collect(Collectors.toMap(i -> alphabet[i], i -> permutation_alphabet[i]));
        System.out.println("Vnesi go tekstot:");
        String text = sc.nextLine();
        int n;
        System.out.println("Kolku promeni sakas da napravis?");
        n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String str = sc.nextLine();
            String [] letters = str.split("\\s+");
            permutation.remove(letters[0].charAt(0));
            permutation.put(letters[0].charAt(0),letters[1].charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        for(char c : text.toCharArray()){
            char t = permutation.get(c);
            sb.append(t);
        }
        pw.print(sb.toString());
        pw.flush();
        sc.close();
    }
}
