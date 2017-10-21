package algorithms.string;

public class RemoveWhiteSpace {

	public static void main(String[] args) {
		String input = "  ( 1   + 7 +(  9 -   5))";
		input = input.replaceAll("\\s",""); 
		System.out.println(input);
	}
}
