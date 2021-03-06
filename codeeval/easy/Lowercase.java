package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Lowercase {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}

		File file;
		BufferedReader reader;

		try {

			file = new File(args[0]);
			reader = new BufferedReader(new FileReader(file));

			String line = null;
			StringBuilder result;

			while ((line = reader.readLine()) != null) {
				result = new StringBuilder(line);
				for (int i = 0; i < line.length(); i++) {
					char ch = line.charAt(i);
					result.setCharAt(i, ch >= 'A' && ch <= 'Z' ? (char) (ch + 'a' - 'A') : ch);
				}
				System.out.println(result);
			}
			reader.close();
		} catch (Exception e) {
		}
	}
}
