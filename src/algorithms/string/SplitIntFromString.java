package algorithms.string;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitIntFromString {

	public static void main(String[] args) {
		
		String str = "abcd1234";
		String[] part = str.split("(?<=\\D)(?=\\d)");
		System.out.println(part[0]);
		System.out.println(part[1]);

		Pattern pattern = Pattern.compile("[a-z]+|\\d+");
		Matcher m = pattern.matcher("123abc345def");
		ArrayList<String> allMatches = new ArrayList<>();
		while (m.find()) {
		    allMatches.add(m.group());
		}
		System.out.println(allMatches);
		
		m = pattern.matcher("a1b2c3d4e5f6h234");
		allMatches.clear();
		while (m.find()) {
		    allMatches.add(m.group());
		}
		System.out.println(allMatches);
	}
}
