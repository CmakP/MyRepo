package algorithms.string;

public class SubStringExm {

	public static void main(String[] args) {
		String word = "Test For Substring";
		String equation = "(2+(2+(5)))";
		
		System.out.println(word.substring(14));  //ring
		System.out.println(word.substring(0, 4));  //Test
		
		char c = word.charAt(5);
		System.out.println(c); //F
		
		char[] chars = word.toCharArray();
		System.out.println(Character.toString(chars[3]).toUpperCase()); //T
		System.out.println(chars); //Test For Substring
		
		int index = equation.indexOf(')');
		System.out.println(index);
		System.out.println(equation.lastIndexOf('(', index));
		System.out.println(Character.isAlphabetic(equation.charAt(2)));
	}

}
