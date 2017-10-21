package util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class InputToFile {

	public static void main(String[] args) throws IOException {
		
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader inputStream = new BufferedReader(reader);
		
		FileOutputStream fileOut = null;
		PrintStream outputStream = null;
		
		try {
			String next;
			fileOut = new FileOutputStream("UserInput.txt");
			outputStream = new PrintStream(fileOut);
			while((next = inputStream.readLine()) != null) {
				if(next.equalsIgnoreCase("exit")) {
					break;
				}
				outputStream.println(next);
			}
		} finally {
			if (inputStream != null) {
                inputStream.close();
            }
            if (fileOut != null) {
            	fileOut.close();
            }
			System.out.println("Closing PrintStream!");
		}
	}
}
