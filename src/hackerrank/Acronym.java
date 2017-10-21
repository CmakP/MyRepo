package hackerrank;

public class Acronym {

	public static void main(String[] args) {

	}
	
	static String acronym(String[] put) {
		StringBuilder ac = new StringBuilder();
		for (String input : put) {
			char c = input.charAt(0);
			
			ac.append(Character.toString(c).toUpperCase() + ".");
		}
		return ac.toString();
	}
}
