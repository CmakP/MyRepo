package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;

public class ReadFileWriteFile {

	public static void main(String[] args) throws IOException {
		Instant startTime = Instant.now();

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("dcart10.txt"));
            outputStream = new PrintWriter(new FileWriter("dcart10.bak"));

            String line;
            while ((line = inputStream.readLine()) != null) {
                outputStream.println(line.toUpperCase());
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        
		Instant endTime = Instant.now();
		System.out.println(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
    }

}
