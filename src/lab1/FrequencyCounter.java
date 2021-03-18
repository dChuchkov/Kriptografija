package lab1;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import static java.util.stream.Collectors.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Map.Entry.*;

public class FrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        Character [] alphabet = {'А','Б','В','Г','Д','Ѓ','Е','Ж','З','Ѕ','И','Ј','К','Л','Љ','М','Н','Њ','О','П','Р','С','Т','Ќ','У','Ф','Х','Ц','Ч','Џ','Ш'};
        HashMap<Character,Double> letterFr = new HashMap<>();
        HashMap<String,Double> twoLettersFr = new HashMap<>();
        HashMap<String,Double> twoLettersFr1 = new HashMap<>();
        HashMap<String,Double> couplesSorted = new HashMap<>();
        HashMap<Character,Double> lettersSorted = new HashMap<>();
        PrintWriter pw1 = new PrintWriter("C:\\Users\\damja\\Desktop\\frekvencijaNaBukvi.csv", "UTF-8");
        PrintWriter pw2 = new PrintWriter("C:\\Users\\damja\\Desktop\\frekvencijaNaParovi.csv", "UTF-8");
        double num_Letters = 0;
        double num_Couples = 0;
        String message = sc.next();

        for (char c : alphabet){
            int counter = 0;

            for (char c1 : message.toCharArray()) {
                if (c == c1)
                    ++counter;
            }
            letterFr.put(c, (double) counter);
        }

        for (int i=0; i < message.length()-1; i++){
            StringBuilder sb = new StringBuilder();
            String couple = sb.append(message.charAt(i)).append(message.charAt(i+1)).toString();

            Double count = twoLettersFr.get(couple);

            if(count == null){
                twoLettersFr.put(couple, 1.0);
            }
            else {
                twoLettersFr.remove(couple);
                twoLettersFr.put(couple,count + 1);
            }
        }
        num_Letters = letterFr.values().stream().mapToDouble(x->x).sum();
        num_Couples = twoLettersFr.values().stream().mapToDouble(x->x).sum();

        for(char c : alphabet){
            Double count = letterFr.get(c);

            if(count != null){
                count /= num_Letters;
                letterFr.remove(c);
                letterFr.put(c,count);

            }
        }
        for (String s : twoLettersFr.keySet()){
            Double count = twoLettersFr.get(s);
            count /= num_Couples;
            twoLettersFr1.put(s,count);
        }
        lettersSorted = letterFr.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue())).collect(toMap(e->e.getKey(), e->e.getValue(), (e1,e2)->e2, LinkedHashMap::new));
        couplesSorted = twoLettersFr1.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue())).collect(toMap(e->e.getKey(), e->e.getValue(), (e1,e2)->e2, LinkedHashMap::new));

        for (char c : lettersSorted.keySet())
            pw1.println(c+"- "+String.format("%.5f", lettersSorted.get(c)));
        pw1.flush();
        for (String c : couplesSorted.keySet())
            pw2.println(c+"-"+String.format("%.5f", couplesSorted.get(c)));
        pw2.flush();
    }
}
