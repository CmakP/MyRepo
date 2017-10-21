package util;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidInputWScanner {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner;
		boolean invalid;
		String input;

		do {
			invalid = false;
			System.out.println();
			System.out.print("Enter Input > ");
			scanner = new Scanner(System.in);
			input = scanner.nextLine();
		   	if(!input.equals("condition")) {
		   		invalid = true;
				System.out.println("Invalid ...");
		   	} 
		} while (invalid);
		scanner.close();
		System.out.println(input);	
	}
}
