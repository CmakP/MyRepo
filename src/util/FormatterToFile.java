package util;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class FormatterToFile {

	public static void main(String[] args) {
		try {
			Formatter output = new Formatter("temp.txt");
			output.format("%s", "Java 101");
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
