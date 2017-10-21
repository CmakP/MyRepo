package algorithms.string;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * MapTester.
 * @author Christopher Thompson
 * @version Jan 15, 2016
 */
public class LetterCount {
    
    private HashMap<Character, Integer> letterCount;

    /**
     * Constructor for objects of type MapTester.
     */
    public LetterCount() {
        letterCount = new HashMap<>();
    }
    
    /**
     * Counts and reports the number of each letter
     * in a specified sentence.
     * @param sentence A string
     */
    public void countLetters(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            if (letterCount.containsKey(sentence.charAt(i))) {
                letterCount.put(sentence.charAt(i), letterCount.get(sentence.charAt(i)) + 1);
            } else {
                letterCount.put(sentence.charAt(i), 1);
            }
        }
        
        Set<Entry<Character, Integer>> entries = letterCount.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LetterCount letterCount = new LetterCount();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a sentence");
        String sentence = scan.nextLine();
        letterCount.countLetters(sentence);
        scan.close();
    }
}
