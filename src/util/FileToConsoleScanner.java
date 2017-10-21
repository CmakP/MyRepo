package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileToConsoleScanner {

	public static void main(String[] args) {
		Scanner input = null;
		try {
			input = new Scanner(new File("a2.txt"));
			while(input.hasNextLine()) {
				System.out.println(input.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(input != null) {
				input.close();
			}
		}
	}
}
