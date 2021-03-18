package lab1;

import java.util.*;
import java.util.stream.*;

class Message{
    private String plaintext;
    private String encrypted;
    static Character [] alphabet = {'А','Б','В','Г','Д','Ѓ','Е','Ж','З','Ѕ','И','Ј','К','Л','Љ','М','Н','Њ','О','П','Р','С','Т','Ќ','У','Ф','Х','Ц','Ч','Џ','Ш'};
    static Character [] alphabet_permutation = {'П','Њ','М','Л','Ј','Ѕ','Ж','Ш','Ч','Х','У','Т','С','О','Н','Љ','К','И','З','Е','Д','В','А','Џ','Ц','Ќ','Ф','Р','Б','Г','Ѓ'};
    static Map<Object, Object> permutation = IntStream.range(0, alphabet.length).boxed()
            .collect(Collectors.toMap(i -> alphabet[i], i -> alphabet_permutation[i]));


    public Message(String plaintext) {
        this.plaintext = plaintext;
        StringBuilder sb = new StringBuilder();
        for (char c : plaintext.toCharArray()){
            sb.append(permutation.get(c));
        }
        encrypted = sb.toString();
    }

    public String getEncrypted() {
        return encrypted;
    }
}

public class Encryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Message message = new Message(str);
        System.out.println(message.getEncrypted());
    }
}
