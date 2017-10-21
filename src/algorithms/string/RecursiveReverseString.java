package algorithms.string;

public class RecursiveReverseString {

	public RecursiveReverseString() {}

	public static void main(String[] args) {
		RecursiveReverseString reverser = new RecursiveReverseString();
		System.out.println(reverser.reverse("Test"));
	}

	public String reverse(String str) {
		int index = str.length() - 1;
		return index == 0 ? str : str.charAt(index) + reverse(str.substring(0, index)); 
	}
}
