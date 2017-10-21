package algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharsInString {

	public static void main(String a[]){
        DuplicateCharsInString dcs = new DuplicateCharsInString();
        dcs.findDuplicateChars("Java2Novice");
    }
	
	public void findDuplicateChars(String str){
        
        Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
        char[] chrs = str.toCharArray();
        for(Character ch:chrs){
            if(dupMap.containsKey(ch)){
                dupMap.put(ch, dupMap.get(ch)+1);
            } else {
                dupMap.put(ch, 1);
            }
        }
        
        dupMap.forEach((k, v) -> { 
        	if(v > 1) {
        	    System.out.println(k + " " + v);
        	}
        });
    }
}
