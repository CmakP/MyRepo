package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerLine {

	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new File("dcart10.txt"));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
		}
		
		scanner = new Scanner(System.in);
		
		System.out.print("Enter mm dd yy: ");
	    String month = scanner.next();
        String day = scanner.next();
        String year = scanner.next();
        System.out.println(month + " " + day + " " + year);
        
        // Prompt the user to enter an integer
		System.out.print("Enter an integer: ");
		int intValue = scanner.nextInt();
		System.out.println("You entered the integer " + intValue);

		// Prompt the user to enter a double value
		System.out.print("Enter a double value: ");
		double doubleValue = scanner.nextDouble();
		System.out.println("You entered the double value " + doubleValue);

		// Prompt the user to enter a string
		System.out.print("Enter a string without space: ");
		String string = scanner.next();
		System.out.println("You entered the string " + string);
	}

}
