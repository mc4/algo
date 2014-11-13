package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class sumOfIntegers {

	public static void main(String[] args) {
	
		File file;
		BufferedReader br;
		int sum = 0;

		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}

		try {

			file = new File(args[0]);
			br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				sum += Integer.parseInt(line);
			}
		} catch (FileNotFoundException e) {
		} catch (IOException ioe) {
		}
		System.out.println(sum);
	}
}
