package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamBufferReader {

	public InputStreamBufferReader() {
		
	}
	public static String getText(String prompt) {
		String string = "";
	//	InputStreamReader reader = new InputStreamReader(System.in);
	//	BufferedReader input = new BufferedReader(reader);
		
		System.out.print(prompt);
		System.out.flush();
		
		//Removes need for explicit closure on both successful and failed control flows
		//Also known as ‘automatic resource management’ (ARM)
		try (InputStreamReader reader = new InputStreamReader(System.in);
			 BufferedReader input = new BufferedReader(reader)) 
		{
			string = input.readLine();
		} catch (IOException e) { // Check for I/O errors
			System.out.println("An IOException hs occured");
			return "";
		}
		return string.trim();
	}
	
	public static void main(String[] args) {
		System.out.println("User entered : " + InputStreamBufferReader.getText("Please type something > "));
    }
}
