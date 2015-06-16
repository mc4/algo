package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StringMask {

	public static void main(String[] args) throws Exception {

		File file;
		BufferedReader reader;

		file = new File(args[0]);
		reader = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = reader.readLine()) != null) {
			StringBuilder result = new StringBuilder(line);

			String[] tokens = line.split(" ");
			String string = tokens[0];
			String mask = tokens[1];

			for (int i = 0; i < string.length(); i++) {
				result.setCharAt(i, mask.charAt(i) == '1' ? Character.toUpperCase(string.charAt(i)) : string.charAt(i));
			}
			System.out.println(result);
		}
		reader.close();

	}
}
