package algorithms.string;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Tokenizer {

	public static void main(String[] args) {
		Map<String, Integer> wordCounts = new Tokenizer().wordCount("Hi HI hi Hi HI hi hi hi");
		wordCounts.forEach((k, v) -> System.out.println(k + " " + v));
	}
	
	private Map<String, Integer> wordCount(String words) {
		StringTokenizer tokenizer = new StringTokenizer(words, " ");
		Map<String, Integer> wordCount = new HashMap<>();
		while(tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			if (wordCount.containsKey(word)) {
				wordCount.put(word, wordCount.get(word) + 1);
			} else {
				wordCount.put(word, 1);
			}
		}
		return wordCount;
	}
}
