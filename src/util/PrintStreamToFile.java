package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamToFile {

	public static void main (String args[])	{
		try {
				FileOutputStream fileOut = 	new FileOutputStream("out.txt");
				PrintStream out = new PrintStream(fileOut);
				for (int i = 0; i < 10; i++) {
					out.print("red");
					out.print("\t");
					out.println("car");
				}
				out.close();
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
}
